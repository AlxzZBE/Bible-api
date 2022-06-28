package com.alex.bibleapi.bibleapi.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class ExceptionDetails {

    private LocalDateTime timeStamp;
    private String title;
    private Integer status;
    private String details;

    public ExceptionDetails newExceptionDetails(RuntimeException e, String title) {
        ExceptionDetails exceptionDetails = new ExceptionDetails();
        exceptionDetails.setTimeStamp(timeStamp = LocalDateTime.now());
        exceptionDetails.setTitle(title);
        exceptionDetails.setStatus(e.getClass().getAnnotation(ResponseStatus.class).value().value());
        exceptionDetails.setDetails(e.getMessage());
        return exceptionDetails;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}