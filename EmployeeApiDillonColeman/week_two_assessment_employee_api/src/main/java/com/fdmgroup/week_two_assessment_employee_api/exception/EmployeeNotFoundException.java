package com.fdmgroup.week_two_assessment_employee_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException() {
        super("Employee Not Found!");
    }
    
}