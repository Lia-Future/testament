package org.liafuture.testament.dto.response;

import lombok.Data;
import org.liafuture.testament.enums.UserGender;

import java.util.Date;

/**
 * Data transfer object representation of User Entity
 */
@Data
public final class UserDTO {
    private int id;
    private String userName;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cellPhoneNumber;
    private Date birthDate;
    private UserGender userGender;
    private String nationality;
}
