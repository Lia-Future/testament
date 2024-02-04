package org.liafuture.testament.service;

import org.liafuture.testament.dto.response.UserDTO;

public interface UserService {
    public UserDTO saveUser(final UserDTO userDTO);
    public UserDTO loginUser(final UserDTO userDTO);
}
