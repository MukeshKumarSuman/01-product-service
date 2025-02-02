package com.nps.exceptionhandler;

import com.nps.exception.ProductNotFoundException;
import com.nps.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse(), HttpStatus.NOT_FOUND);
    }
}
