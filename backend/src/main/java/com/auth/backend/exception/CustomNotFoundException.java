package com.auth.backend.exception;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(String message){
        super(message);
    }
}
