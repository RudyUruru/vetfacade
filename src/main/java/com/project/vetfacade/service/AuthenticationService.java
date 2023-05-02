package com.project.vetfacade.service;

import com.project.vetfacade.dto.*;
import com.project.vetfacade.user.Role;
import com.project.vetfacade.user.User;
import com.project.vetfacade.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


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

    public RefreshTokenResponse refreshAccessToken(RefreshTokenRequest refresh) {
        String refresh_token = refresh.getRefresh_token();
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


}
