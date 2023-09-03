package com.glabs.membershipregister.utils;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ResponseBuilder {

    public ResponseEntity prepareSuccessResponse(Object data, HttpStatus httpStatus){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", data);
        return ResponseEntity.status(httpStatus).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    public ResponseEntity prepareErrorResponse(HttpStatus httpStatus){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("errorCode", httpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("errorMessage", httpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return ResponseEntity.status(httpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
    }
}
