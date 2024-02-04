package org.liafuture.testament.converter;

import org.liafuture.testament.entity.User;
import org.liafuture.testament.security.user.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityToUserDetailsConverter implements Converter<User, UserDetailsImpl> {

    @Override
    public UserDetailsImpl convert(final User source) {
        final List<GrantedAuthority> authorities = source.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return UserDetailsImpl.builder()
                .id(source.getId())
                .authorities(authorities)
                .email(source.getEmail())
                .password(source.getPassword())
                .username(source.getUsername())
                .build();
    }
}
