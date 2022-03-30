package com.application.exception_wrappers;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
