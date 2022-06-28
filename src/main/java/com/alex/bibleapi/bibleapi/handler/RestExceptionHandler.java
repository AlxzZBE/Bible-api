package com.alex.bibleapi.bibleapi.handler;

import com.alex.bibleapi.bibleapi.exceptions.ExceptionDetails;
import com.alex.bibleapi.bibleapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException nfe) {
        return new ResponseEntity<>(new ExceptionDetails(nfe), HttpStatus.NOT_FOUND);
    }
}