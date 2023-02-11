package com.ohspaces.bookmyspace.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class BookSpaceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookSpaceException.class)
    public ResponseEntity<ApiError> handleBookException(BookSpaceException ex) {
        ApiError error = ApiError.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> handleGenericException(Throwable ex) {


        ApiError error = ApiError.builder().code("BSE555").message("Internal Server Error").build();


        return new ResponseEntity<ApiError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
