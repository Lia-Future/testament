package org.liafuture.testament.service;

import org.liafuture.testament.dto.request.LoginRequestDTO;
import org.liafuture.testament.dto.request.SignUpRequestDTO;
import org.liafuture.testament.dto.response.JwtResponse;
import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;

public interface AuthenticationService {
    public String signUp(final SignUpRequestDTO signUpRequest) throws UsernameAlreadyExists, EmailAlreadyExists;

    public JwtResponse login(final LoginRequestDTO loginRequestDTO);
}
