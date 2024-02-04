package org.liafuture.testament.converter;

import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.entity.RoleEntity;
import org.liafuture.testament.entity.UserEntity;
import org.liafuture.testament.enums.UserGender;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public final class SignUpRequestToUserEntityConverter implements Converter<SignUpRequestDTO, UserEntity> {
    @Override
    public UserEntity convert(final SignUpRequestDTO source) {

        return UserEntity.builder()
                .userName(source.getUserName())
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
