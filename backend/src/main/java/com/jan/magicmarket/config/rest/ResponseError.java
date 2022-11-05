package com.jan.magicmarket.config.rest;

public class ResponseError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ResponseError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public ResponseError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }
}
