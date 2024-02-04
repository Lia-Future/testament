package org.liafuture.testament.converter;

import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDTOConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(final User source) {

        return null;
    }
}
