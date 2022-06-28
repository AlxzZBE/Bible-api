package com.alex.bibleapi.bibleapi.handler;

import com.alex.bibleapi.bibleapi.exceptions.AlreadyExistsException;
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
        return new ResponseEntity<>(new ExceptionDetails()
                .newExceptionDetails(nfe, "Not Found Exception, Check the details and the Documentation"),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerAlreadyExistsException(AlreadyExistsException aee) {
        return new ResponseEntity<>(new ExceptionDetails()
                .newExceptionDetails(aee, "Already Exists Exception, Check the details and the Documentation"),
                HttpStatus.CONFLICT);
    }
}