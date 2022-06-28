package com.alex.bibleapi.bibleapi.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ExceptionDetails {

    private LocalDateTime timeStamp;
    private String title;
    private Integer status;
    private String details;

    public ExceptionDetails(NotFoundException nfe) {
        this.timeStamp = LocalDateTime.now();
        this.title = "Not Found Exception, Check the details and the Documentation";
        this.status = HttpStatus.NOT_FOUND.value();
        this.details = nfe.getMessage();
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
