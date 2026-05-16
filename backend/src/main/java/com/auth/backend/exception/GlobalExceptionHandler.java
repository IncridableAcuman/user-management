package com.auth.backend.exception;

import com.auth.backend.dto.error.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomUnauthorizedException.class)
    public ResponseEntity<ErrorResponse> customUnauthorizedExceptionHandler(CustomUnauthorizedException exception, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse.from(exception,HttpStatus.UNAUTHORIZED,request));
    }
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorResponse> customNotFoundExceptionHandler(CustomNotFoundException exception,HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.from(exception,HttpStatus.NOT_FOUND,request));
    }
    @ExceptionHandler(CustomInternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> customInternalServerErrorExceptionHandler(CustomInternalServerErrorException exception,HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.from(exception,HttpStatus.INTERNAL_SERVER_ERROR,request));
    }
    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity<ErrorResponse> customBadRequestExceptionHandler(CustomBadRequestException exception,HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.from(exception,HttpStatus.BAD_REQUEST,request));
    }
}
