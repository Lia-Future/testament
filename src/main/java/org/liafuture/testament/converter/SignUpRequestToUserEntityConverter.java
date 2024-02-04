package org.liafuture.testament.converter;

import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public final class SignUpRequestToUserEntityConverter implements Converter<SignUpRequestDTO, User> {
    @Override
    public User convert(final SignUpRequestDTO source) {

        return User.builder()
                .username(source.getUsername())
                .name(source.getName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .password(source.getPassword())
                .cellPhoneNumber(source.getCellPhoneNumber())
                .birthDate(source.getBirthDate())
                .userGender(source.getUserGender())
                .nationality(source.getNationality())
                .roles(new HashSet<>())
                .build();
    }
}
