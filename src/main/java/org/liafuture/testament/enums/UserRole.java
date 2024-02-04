package org.liafuture.testament.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ROLE_USER("user"),
    ROLE_MODERATOR("moderator"),
    ROLE_ADMIN("admin");

    private final String rolName;
}
