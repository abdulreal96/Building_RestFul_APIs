package com.abdulreal.buildingRestFulAPIs.errorHandling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleInvalidArgumentException(ConstraintViolationException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getConstraintViolations().forEach(error -> {
            errorMap.put(error.getPropertyPath().toString(), error.getMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String, String> handledUserNotFoundException(EmployeeNotFoundException ex){
        Map<String, String> error = new HashMap<>();
        error.put("errorMessage", ex.getMessage());

        return error;
    }
}
