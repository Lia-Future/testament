package org.liafuture.testament.converter;

import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class UserDTOToUserEntityConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO source) {

        return null;
    }
}
