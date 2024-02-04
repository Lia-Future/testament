package org.liafuture.testament.exception.user;

import org.liafuture.testament.exception.TestamentAppException;

public final class EmailAlreadyExists extends TestamentAppException {
    public EmailAlreadyExists(final String message) {
        super(message);
    }
}
