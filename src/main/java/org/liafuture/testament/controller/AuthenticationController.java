package org.liafuture.testament.controller;

import org.liafuture.testament.dto.request.LoginRequestDTO;
import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.dto.response.JwtResponse;
import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;
import org.liafuture.testament.service.AuthenticationService;
import org.liafuture.testament.service.UserService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Controller to Handle Users Information
 */
@Controller
@RequestMapping("/api/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    private AuthenticationController(final AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(final @RequestBody SignUpRequestDTO request) throws EmailAlreadyExists, UsernameAlreadyExists {
        final String response = this.authenticationService.signUp(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> login(final @RequestBody LoginRequestDTO request) {
        final JwtResponse response = this.authenticationService.login(request);

        return ResponseEntity.ok(response);
    }
}
