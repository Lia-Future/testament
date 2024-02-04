package org.liafuture.testament.service.impl;

import lombok.RequiredArgsConstructor;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.service.UserValidationService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class UserValidationServiceImpl implements UserValidationService {
    private final UserRepository userRepository;

    @Override
    public boolean existsByEmail(final String email) {
        return this.userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean existsByUsername(final String userName) {
        //TODO Change this to optional
        return this.userRepository.findByUserName(userName) != null;
    }
}
