package com.glabs.membershipregister.advice;

import com.glabs.membershipregister.utils.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
@Slf4j
public class ErrorResponseAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        log.error("error occurred", exception);
        return ResponseBuilder.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
