package com.auth.backend.exception;

public class CustomInternalServerErrorException extends RuntimeException{
    public CustomInternalServerErrorException(String message){
        super(message);
    }
}
