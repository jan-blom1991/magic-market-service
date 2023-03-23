package com.jan.magicmarket.config.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ResponseSeverity.ERROR,
                ResponseMessage.ERROR_OCCURRED.getLabel()
        );

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @ExceptionHandler({ EntityIdentifierException.class })
    public ResponseEntity<Object> handleEntityIdentifier(Exception ex, WebRequest request) {

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ResponseMessage.ENTITY_NOT_FOUND.getLabel()
        );

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @ExceptionHandler({ EntityTokenException.class })
    public ResponseEntity<Object> handleEntityToken(Exception ex, WebRequest request) {

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ResponseMessage.ENTITY_NOT_CHANGED.getLabel()
        );

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }


    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
                                                            WebRequest request) {

        StringBuilder message = new StringBuilder("Constraint violation:\n");

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            message.append(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage() + "\n");
        }

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                message.toString());

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                   WebRequest request) {

        String message = ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                message);

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        StringBuilder message = new StringBuilder("Argument not valid:\n");

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            message.append(error.getField() + ": " + error.getDefaultMessage() + "\n");
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            message.append(error.getObjectName() + ": " + error.getDefaultMessage() + "\n");
        }

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                message.toString());

        return handleExceptionInternal(ex, response, headers, response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatus status,
                                                                          WebRequest request) {

        String message = ex.getParameterName() + " parameter is missing";

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                message);

        return handleExceptionInternal(ex, response, headers, response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request) {

        String message = "No controller found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.NOT_FOUND,
                ResponseSeverity.ERROR,
                message);

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {

        StringBuilder message = new StringBuilder();
        message.append(ex.getMethod());
        message.append(" method is not supported for this request. Supported methods are ");
        Objects.requireNonNull(ex.getSupportedHttpMethods()).forEach(t -> message.append(t).append(" "));

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.METHOD_NOT_ALLOWED,
                ResponseSeverity.ERROR,
                message.toString());

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers,
                                                                     HttpStatus status,
                                                                     WebRequest request) {

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage());

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }
}
