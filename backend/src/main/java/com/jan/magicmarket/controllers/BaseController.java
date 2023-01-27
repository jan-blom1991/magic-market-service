package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.Labeled;
import com.jan.magicmarket.config.rest.ResponseMessage;
import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.config.rest.ResponseSeverity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    public static <T> ResponseEntity<ResponseObject<T>> generateResponse(ResponseObject<T> responseObject, HttpServletRequest request) {
        if (responseObject.getMessage() == null) {
            if (responseObject.getSeverity() == ResponseSeverity.SUCCESS) {
                responseObject.setMessage(determineSuccessMessage(request).getLabel());
            } else if (responseObject.getSeverity() == ResponseSeverity.ERROR) {
                responseObject.setMessage(determineErrorMessage(request).getLabel());
            }
        }

        return new ResponseEntity<>(responseObject, new HttpHeaders(), responseObject.getStatus());
    }

    private static ResponseMessage determineSuccessMessage(HttpServletRequest request) {
        switch (RequestMethod.valueOf(request.getMethod())) {
            case GET:
                return ResponseMessage.ENTITY_FOUND;
            case POST:
                return ResponseMessage.ENTITY_CREATED;
            case PUT:
                return ResponseMessage.ENTITY_CHANGED;
            case DELETE:
                return ResponseMessage.ENTITY_DELETED;
            default:
                return ResponseMessage.ERROR_OCCURRED;
        }
    }

    private static ResponseMessage determineErrorMessage(HttpServletRequest request) {
        switch (RequestMethod.valueOf(request.getMethod())) {
            case GET:
                return ResponseMessage.ENTITY_NOT_FOUND;
            case POST:
                return ResponseMessage.ENTITY_NOT_CREATED;
            case PUT:
                return ResponseMessage.ENTITY_NOT_CHANGED;
            case DELETE:
                return ResponseMessage.ENTITY_NOT_DELETED;
            default:
                return ResponseMessage.ERROR_OCCURRED;
        }
    }

    enum RequestMethod implements Labeled<String> {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE");

        private final String label;

        RequestMethod(String label) {
            this.label = label;
        }

        @Override
        public String getLabel() {
            return null;
        }
    }
}
