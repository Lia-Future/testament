package org.liafuture.testament.converter;

import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDTOConverter implements Converter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(final UserEntity source) {

        return null;
    }
}
