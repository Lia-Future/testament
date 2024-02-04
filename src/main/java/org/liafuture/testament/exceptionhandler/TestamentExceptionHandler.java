package org.liafuture.testament.exceptionhandler;

import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class TestamentExceptionHandler {
    @ExceptionHandler(value = EmailAlreadyExists.class)
    protected ResponseEntity<String> handleEmailAlreadyExists(final RuntimeException ex, final WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(value = UsernameAlreadyExists.class)
    protected ResponseEntity<String> handleUserNameAlreadyExists(final RuntimeException ex, final WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
