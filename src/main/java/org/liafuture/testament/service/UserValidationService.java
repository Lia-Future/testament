package org.liafuture.testament.service;

public interface UserValidationService {
    public boolean existsByEmail(final String email);
    public boolean existsByUsername(final String userName);
}
