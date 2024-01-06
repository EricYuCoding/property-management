package com.mycompany.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class AuthenticationHandler {

    private final Logger logger =LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<List<ErrorModel>> handleAuthentication(AuthenticationException ate){
        for (ErrorModel errors : ate.getErrors()) {
            logger.info("Wrong username or password - {} - {}", errors.getCode(), errors.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(ate.getErrors(), HttpStatus.UNAUTHORIZED);
    }
}
