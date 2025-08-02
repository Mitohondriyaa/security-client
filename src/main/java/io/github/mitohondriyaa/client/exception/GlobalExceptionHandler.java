package io.github.mitohondriyaa.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Info> handleTokenNotAvailableException(
        TokenNotAvailableException exception
    ) {
        Info info = new Info(exception.getMessage());

        return new ResponseEntity<>(info, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<Info> handleOtherExceptions(
        Exception exception
    ) {
        Info info = new Info(exception.getMessage());

        return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}