package com.jan.magicmarket.config.rest;

import com.jan.magicmarket.config.constants.Labeled;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public abstract class ResponseUtil {

    public static <T> ResponseEntity<ResponseObject<T>> buildSuccessResponse(Class<T> type, Long id, HttpServletRequest request) {
        ResponseObject<T> response = new ResponseObject<>(
                HttpStatus.OK,
                ResponseSeverity.SUCCESS,
                determineSuccessMessage(request),
                null);

        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
    }

    public static <T> ResponseEntity<ResponseObject<T>> buildSuccessResponse(T body, HttpServletRequest request) {
        ResponseObject<T> response = new ResponseObject<>(
                HttpStatus.OK,
                ResponseSeverity.SUCCESS,
                determineSuccessMessage(request),
                body);

        return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
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
                return ResponseMessage.INFORMATION_CHANGED;
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
