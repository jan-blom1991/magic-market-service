package com.jan.magicmarket.services;

import com.jan.magicmarket.config.rest.ResponseMessage;
import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.config.rest.ResponseSeverity;
import com.jan.magicmarket.model.User;
import com.jan.magicmarket.transfer.TransferObject;
import com.jan.magicmarket.util.TransferObjectBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class BaseService {

    protected User user;

    public BaseService() {
        this.transferObjectBuilder = new TransferObjectBuilder();
    }

    protected final TransferObjectBuilder transferObjectBuilder;

    public static <T> ResponseObject<T> buildResponse(TransferObject<T> body, ResponseSeverity severity, ResponseMessage message) {
        return new ResponseObject<>(
                HttpStatus.OK,
                severity,
                message.getLabel(),
                body);
    }

    public static <T> ResponseObject<T> buildResponse(ResponseSeverity severity, ResponseMessage message) {
        return new ResponseObject<>(
                HttpStatus.OK,
                severity,
                message.getLabel(),
                null);
    }

    public static <T> ResponseObject<T> buildResponse(TransferObject<T> body) {
        return new ResponseObject<>(
                HttpStatus.OK,
                ResponseSeverity.SUCCESS,
                null,
                body);
    }
}
