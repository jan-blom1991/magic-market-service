package com.jan.magicmarket.config.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class RestResponse {

    private final HttpStatus status;
    private final Object body;
    private final RestResponseSeverity responseType;
    private final RestResponseMessage message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;

    public RestResponse(HttpStatus status, Object body, RestResponseSeverity responseType, RestResponseMessage message, LocalDateTime timestamp) {
        this.status = status;
        this.body = body;
        this.responseType = responseType;
        this.message = message;
        this.timestamp = timestamp;
    }
}
