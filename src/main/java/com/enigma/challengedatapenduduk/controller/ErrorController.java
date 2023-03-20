package com.enigma.challengedatapenduduk.controller;

import com.enigma.challengedatapenduduk.exception.*;
import com.enigma.challengedatapenduduk.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> HandleDataNotFoundException(NotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage(),"400"));
    }
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorResponse> HandleDuplicateException(DuplicateException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(),"400"));
    }
    @ExceptionHandler(DataIntegrationException.class)
    public ResponseEntity<ErrorResponse> HandleDataIngegrityException(DataIntegrationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(),"400"));
    }
    @ExceptionHandler(DataEmptyException.class)
    public ResponseEntity<ErrorResponse> HandleDataEmptyException(DataEmptyException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage(), "400"));
    }
    @ExceptionHandler(FailedToRunException.class)
    public ResponseEntity<ErrorResponse> HandleFailedToRun(FailedToRunException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage(),"400"));
    }
}
