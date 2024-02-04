package org.liafuture.testament.service.impl;

import lombok.RequiredArgsConstructor;
import org.liafuture.testament.converter.UserEntityToUserDetailsConverter;
import org.liafuture.testament.entity.UserEntity;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.security.user.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class UserDetailsServiceImpl implements UserDetailsService {
    private final UserEntityToUserDetailsConverter userEntityToUserDetailsConverter;
    private final UserRepository userRepository;

    @Override
    public UserDetailsImpl loadUserByUsername(final String username) {
        final UserEntity userEntity = this.userRepository.findByUserName(username);

        return this.userEntityToUserDetailsConverter.convert(userEntity);
    }
}
