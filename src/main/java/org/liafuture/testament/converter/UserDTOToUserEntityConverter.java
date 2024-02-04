package org.liafuture.testament.converter;

import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class UserDTOToUserEntityConverter implements Converter<UserDTO, UserEntity> {

    @Override
    public UserEntity convert(final UserDTO source) {

        return null;
    }
}
