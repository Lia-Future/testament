package org.liafuture.testament.exceptionhandler;

import org.liafuture.testament.exception.TestamentAppException;
import org.liafuture.testament.exception.user.EmailAlreadyExists;
import org.liafuture.testament.exception.user.UsernameAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class TestamentExceptionHandler {
    @ExceptionHandler(value = { EmailAlreadyExists.class, UsernameAlreadyExists.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<?> handleEmailAlreadyExists(final TestamentAppException ex, final WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
