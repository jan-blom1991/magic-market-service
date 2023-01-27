package com.jan.magicmarket.services;

import com.jan.magicmarket.config.rest.ResponseMessage;
import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.config.rest.ResponseSeverity;
import com.jan.magicmarket.transfer.TransferObject;
import com.jan.magicmarket.util.TransferObjectBuilder;
import org.springframework.http.HttpStatus;

public abstract class BaseService {

    public BaseService() {
        this.transferObjectBuilder = new TransferObjectBuilder();
    }

    protected final TransferObjectBuilder transferObjectBuilder;

    public static <T> ResponseObject<T> buildSuccessResponse(TransferObject<T> body, ResponseMessage message) {
        return new ResponseObject<>(
                HttpStatus.OK,
                ResponseSeverity.SUCCESS,
                message.getLabel(),
                body);
    }

    public static <T> ResponseObject<T> buildSuccessResponse(TransferObject<T> body) {
        return new ResponseObject<>(
                HttpStatus.OK,
                ResponseSeverity.SUCCESS,
                null,
                body);
    }

    public static <T> ResponseObject<T> buildErrorResponse(ResponseMessage message) {
        return new ResponseObject<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ResponseSeverity.ERROR,
                message.getLabel());
    }

    public static <T> ResponseObject<T> buildErrorResponse() {
        return new ResponseObject<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ResponseSeverity.ERROR);
    }
}
