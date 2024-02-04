package org.liafuture.testament.service.impl;

import lombok.RequiredArgsConstructor;
import org.liafuture.testament.converter.UserDTOToUserEntityConverter;
import org.liafuture.testament.converter.UserEntityToUserDTOConverter;
import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.User;
import org.liafuture.testament.repository.UserRepository;
import org.liafuture.testament.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class UserServiceImpl implements UserService {
    private final UserDTOToUserEntityConverter userDTOToUserEntityConverter;
    private final UserEntityToUserDTOConverter userEntityToUserDTOConverter;
    private final UserRepository userRepository;

    @Override
    public UserDTO saveUser(final UserDTO requestUser) {
        final User userEntity = this.userDTOToUserEntityConverter.convert(requestUser);

        try {

        } catch (final Exception e) {

        }

        return this.userEntityToUserDTOConverter.convert(userEntity);
    }

    @Override
    public UserDTO loginUser(final UserDTO requestUser) {
        final User userEntity = this.userDTOToUserEntityConverter.convert(requestUser);

        try {

        } catch (final Exception e) {

        }

        return this.userEntityToUserDTOConverter.convert(userEntity);
    }
}
