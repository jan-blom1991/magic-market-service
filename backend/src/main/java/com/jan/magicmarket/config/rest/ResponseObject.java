package com.jan.magicmarket.config.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jan.magicmarket.transfer.TransferObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseObject<T> {

    private int statusCode;
    private String statusPhrase;
    private ResponseSeverity severity;
    private String message;
    private TransferObject<T> body = null;
    private List<String> errors = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;

    @JsonIgnore
    private HttpStatus status;

    public ResponseObject(HttpStatus status, ResponseSeverity severity) {
        super();
        this.status = status;
        this.statusCode = status.value();
        this.statusPhrase = status.getReasonPhrase();
        this.severity = severity;
        this.timestamp = LocalDateTime.now();
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, String message) {
        this(status, severity);
        this.message = message;
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, String message, List<String> errors) {
        this(status, severity);
        this.message = message;
        this.errors = errors;
    }

    public ResponseObject(HttpStatus status, ResponseSeverity severity, String message, TransferObject<T> body) {
        this(status, severity);
        this.message = message;
        this.body = body;
    }
}
