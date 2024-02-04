package org.liafuture.testament.exception;

public abstract class TestamentAppException extends Exception {
    public TestamentAppException() {
    }

    public TestamentAppException(final String message) {
        super(message);
    }

    public TestamentAppException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TestamentAppException(final Throwable cause) {
        super(cause);
    }
}
