package com.sumanth.student_management_system.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sumanth.student_management_system.exception.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleStudentNotFoundException(StudentNotFoundException ex) {

        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("message", ex.getMessage());

        return errorResponse;
    }
}