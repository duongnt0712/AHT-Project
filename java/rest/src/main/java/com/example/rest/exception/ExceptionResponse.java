package com.example.rest.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date date;
    private String message;
    private String details;

    public ExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }
}
