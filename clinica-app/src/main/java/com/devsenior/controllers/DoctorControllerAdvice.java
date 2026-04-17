package com.devsenior.controllers;

import com.devsenior.exceptions.DoctorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class DoctorControllerAdvice {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Object> notFound(DoctorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
