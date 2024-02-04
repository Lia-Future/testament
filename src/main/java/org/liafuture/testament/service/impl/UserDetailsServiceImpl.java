package org.liafuture.testament.service.impl;

import lombok.RequiredArgsConstructor;
import org.liafuture.testament.converter.UserEntityToUserDetailsConverter;
import org.liafuture.testament.entity.User;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.security.user.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public final class UserDetailsServiceImpl implements UserDetailsService {
    private final UserEntityToUserDetailsConverter userEntityToUserDetailsConverter;
    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(final String username) {
        final Optional<User> userEntity = this.userRepository.findByUsername(username);

        return userEntity
                .map(this.userEntityToUserDetailsConverter::convert)
                .orElse(null);
    }
}
