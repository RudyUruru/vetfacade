package com.project.vetfacade.service;

import com.project.vetfacade.dto.AuthenticationRequest;
import com.project.vetfacade.dto.AuthenticationResponse;
import com.project.vetfacade.dto.RefreshTokenResponse;
import com.project.vetfacade.dto.RegisterRequest;
import com.project.vetfacade.user.Role;
import com.project.vetfacade.user.User;
import com.project.vetfacade.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MailSenderService mailSender;

    public boolean register(String email) {
        if (!userRepo.findByEmail(email).isEmpty())
            return false;
        var user = User.builder()
                .email(email)
                .role(Role.USER)
                .activationCode(UUID.randomUUID().toString())
                .build();
        userRepo.save(user);
        return true;
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        var jwtRefreshToken = jwtService.generateRefreshToken(user);
        var jwtAccessToken = jwtService.generateAccessToken(user);
        return AuthenticationResponse.builder()
                .refresh_token(jwtRefreshToken)
                .access_token(jwtAccessToken)
                .build();
    }

    public RefreshTokenResponse refreshAccessToken(String refresh_token) {
        String email = jwtService.extractUsername(refresh_token);
        var user = userRepo.findByEmail(email).orElseThrow();
        String accessToken = "";
        if (jwtService.isTokenValid(refresh_token, user)) {
            accessToken = jwtService.generateAccessToken(user);
            return RefreshTokenResponse.builder()
                    .access_token(accessToken)
                    .build();
        }
        return RefreshTokenResponse.builder()
                .access_token(accessToken)
                .build();
    }

    public boolean activateUser(String code, String password) {
        User user = userRepo.findByActivationCode(code);
        if (user == null)
            return false;
        user.setActivationCode(null);
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
        return true;
    }
}
