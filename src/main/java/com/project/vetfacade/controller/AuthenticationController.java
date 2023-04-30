package com.project.vetfacade.controller;

import com.project.vetfacade.dto.AuthenticationRequest;
import com.project.vetfacade.dto.AuthenticationResponse;
import com.project.vetfacade.dto.RefreshTokenResponse;
import com.project.vetfacade.dto.RegisterRequest;
import com.project.vetfacade.service.AuthenticationService;
import com.project.vetfacade.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v5/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam String email) {
        if (authenticationService.register(email))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, @RequestParam String password) {
        authenticationService.activateUser(code, password);
        return "login";
    }
    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refreshAccessToken(@RequestParam String refresh_token) {
            return ResponseEntity.ok(authenticationService.refreshAccessToken(refresh_token));
    }
}

