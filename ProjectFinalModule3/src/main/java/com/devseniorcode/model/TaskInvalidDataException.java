package com.devseniorcode.model;

public class TaskInvalidDataException extends RuntimeException {
    public TaskInvalidDataException(String message) {
        super(message);
    }
}
