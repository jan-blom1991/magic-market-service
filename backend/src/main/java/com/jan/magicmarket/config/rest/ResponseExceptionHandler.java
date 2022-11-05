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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                errors);

        return handleExceptionInternal(ex, response, headers, response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatus status,
                                                                          WebRequest request) {

        String error = ex.getParameterName() + " parameter is missing";

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList(error));

        return handleExceptionInternal(ex, response, headers, response.getStatus(), request);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
                                                            WebRequest request) {

        List<String> errors = new ArrayList<>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " +
                    violation.getPropertyPath() + ": " + violation.getMessage());
        }

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                errors);

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
                                                                   WebRequest request) {

        String error = ex.getName() + " should be of type " + Objects.requireNonNull(ex.getRequiredType()).getName();

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.BAD_REQUEST,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList(error));

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String error = "No controller found for " + ex.getHttpMethod() + " " + ex.getRequestURL();

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.NOT_FOUND,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList(error));

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {

        StringBuilder error = new StringBuilder();
        error.append(ex.getMethod());
        error.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> error.append(t + " "));

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.METHOD_NOT_ALLOWED,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList(error.toString()));

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers,
                                                                     HttpStatus status,
                                                                     WebRequest request) {

        StringBuilder error = new StringBuilder();
        error.append(ex.getContentType());
        error.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> error.append(t + ", "));

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                ResponseSeverity.ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList(error.toString()));

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

        ResponseObject<?> response = new ResponseObject<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ResponseSeverity.ERROR,
                ResponseMessage.ERROR_OCCURRED,
                Collections.singletonList(ex.toString()));

        return handleExceptionInternal(ex, response, new HttpHeaders(), response.getStatus(), request);
    }
}
