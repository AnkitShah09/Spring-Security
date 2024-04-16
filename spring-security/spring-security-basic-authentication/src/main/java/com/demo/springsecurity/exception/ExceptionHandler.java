package com.demo.springsecurity.exception;


import com.demo.springsecurity.model.ErrorResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNameNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity(
                new ErrorResponse(LocalDateTime.now(), e.getHttpStatus().value(), e.getErrorMessage())
                , e.getHttpStatus()
        );
    }
}
