package org.liafuture.testament.service.impl;

import lombok.RequiredArgsConstructor;
import org.liafuture.testament.converter.SignUpRequestToUserEntityConverter;
import org.liafuture.testament.dto.request.LoginRequestDTO;
import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.dto.response.JwtResponse;
import org.liafuture.testament.entity.RoleEntity;
import org.liafuture.testament.entity.UserEntity;
import org.liafuture.testament.enums.UserRole;
import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;
import org.liafuture.testament.repository.RoleRepository;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.security.jwt.JwtUtil;
import org.liafuture.testament.security.user.UserDetailsImpl;
import org.liafuture.testament.service.AuthenticationService;
import org.liafuture.testament.service.UserValidationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public final class AuthenticationServiceImpl implements AuthenticationService {
    private final SignUpRequestToUserEntityConverter signUpRequestToUserEntityConverter;
    private final UserValidationService userValidationService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public String signUp(final SignUpRequestDTO signUpRequest) throws UsernameAlreadyExists, EmailAlreadyExists {
        if (this.userValidationService.existsByUsername(signUpRequest.getUserName())) {
            throw new UsernameAlreadyExists("Error: Username is already taken!");
        }

        if (this.userValidationService.existsByEmail(signUpRequest.getEmail())) {
            throw new EmailAlreadyExists("Error: Email is already in use!");
        }

        final UserEntity user = this.signUpRequestToUserEntityConverter.convert(signUpRequest);

        final Set<UserRole> strRoles = signUpRequest.getRolesOrDefault();
        final Set<RoleEntity> roles = strRoles.stream()
                .map(this.roleRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        //TODO add jetbrains notnull annotation
        user.setRoles(roles);
        this.userRepository.save(user);

        return "User registered successfully!";
    }

    @Override
    public JwtResponse login(final LoginRequestDTO loginRequest) {
        final var authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String jwt = this.jwtUtil.generateJwtToken(authentication);

        final UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        final List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles);
    }
}
