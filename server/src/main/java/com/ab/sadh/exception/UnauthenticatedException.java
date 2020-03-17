package com.ab.sadh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthenticatedException extends Exception {
    public UnauthenticatedException(String UNAUTHORIZED_MESSAGE) {
    }
}
