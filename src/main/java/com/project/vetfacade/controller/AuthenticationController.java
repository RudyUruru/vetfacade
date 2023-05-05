package com.project.vetfacade.controller;

import com.project.vetfacade.dto.AuthenticationRequest;
import com.project.vetfacade.dto.AuthenticationResponse;
import com.project.vetfacade.dto.RefreshTokenRequest;
import com.project.vetfacade.dto.RefreshTokenResponse;
import com.project.vetfacade.service.AuthenticationService;
import com.project.vetfacade.user.User;
import com.project.vetfacade.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v5/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshTokenResponse> refreshAccessToken(@RequestBody RefreshTokenRequest refresh) {
            return ResponseEntity.ok(authenticationService.refreshAccessToken(refresh));
    }
}

