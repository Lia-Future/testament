package org.liafuture.testament.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liafuture.testament.dto.request.LoginRequestDTO;
import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.dto.response.JwtResponse;
import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;
import org.liafuture.testament.repository.RoleRepository;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.security.jwt.JwtUtil;
import org.liafuture.testament.security.user.UserDetailsImpl;
import org.liafuture.testament.service.AuthenticationService;
import org.liafuture.testament.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller to Handle Users Information
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authentication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(final @RequestBody SignUpRequestDTO request) throws EmailAlreadyExists, UsernameAlreadyExists {
        final String response = this.authenticationService.signUp(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(final @RequestBody LoginRequestDTO loginRequest) {
        final JwtResponse response = this.authenticationService.login(loginRequest);

        return ResponseEntity.ok(response);
    }
}
