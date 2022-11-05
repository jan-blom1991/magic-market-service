package com.jan.magicmarket.config.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseObject<T> {

    private final HttpStatus status;
    private final int statusCode;
    private final String statusPhrase;
    private final ResponseSeverity severity;
    private String message;
    private T body = null;
    private List<String> errors = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;

    public ResponseObject(HttpStatus status, ResponseSeverity severity) {
        super();
        this.status = status;
        this.statusCode = status.value();
        this.statusPhrase = status.getReasonPhrase();
        this.severity = severity;
        this.timestamp = LocalDateTime.now();
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, ResponseMessage message, List<String> errors) {
        this(status, severity);
        this.message = message.getLabel();
        this.errors = errors;
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, String message, List<String> errors) {
        this(status, severity);
        this.message = message;
        this.errors = errors;
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, ResponseMessage message, T body) {
        this(status, severity);
        this.message = message.getLabel();
        this.body = body;
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, String message, T body) {
        this(status, severity);
        this.message = message;
        this.body = body;
    }

    @JsonIgnore
    public HttpStatus getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public ResponseSeverity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public T getBody() {
        return body;
    }

    public List<String> getErrors() {
        return errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
