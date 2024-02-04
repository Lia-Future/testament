package org.liafuture.testament.dto.request;

import lombok.Data;
import org.liafuture.testament.enums.UserGender;
import org.liafuture.testament.enums.UserRole;

import java.util.Date;
import java.util.Set;

@Data
public final class SignUpRequestDTO {
    private int id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cellPhoneNumber;
    private Date birthDate;
    private UserGender userGender;
    private String nationality;
    private Set<UserRole> roles;

    public Set<UserRole> getRolesOrDefault() {
        if (this.roles == null || this.roles.isEmpty()) {
            return Set.of(UserRole.ROLE_USER);
        }
        return this.roles;
    }
}
