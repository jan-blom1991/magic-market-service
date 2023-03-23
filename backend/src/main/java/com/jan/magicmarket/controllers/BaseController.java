package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    public static <T> ResponseEntity<ResponseObject<T>> generateResponse(ResponseObject<T> responseObject, HttpServletRequest request) {
        return new ResponseEntity<>(responseObject, new HttpHeaders(), responseObject.getStatus());
    }
}
