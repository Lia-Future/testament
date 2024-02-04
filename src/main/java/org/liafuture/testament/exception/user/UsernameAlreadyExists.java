package org.liafuture.testament.exception.user;

import org.liafuture.testament.exception.TestamentAppException;

public final class UsernameAlreadyExists extends TestamentAppException {
    public UsernameAlreadyExists(final String message) {
        super(message);
    }
}
