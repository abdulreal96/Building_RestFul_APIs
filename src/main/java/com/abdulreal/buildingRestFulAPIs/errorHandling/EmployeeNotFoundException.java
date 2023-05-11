package com.abdulreal.buildingRestFulAPIs.errorHandling;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
