package de.xenadu.userservice.controller;

public class RestBadRequestException extends RuntimeException {

    public RestBadRequestException() {
    }

    public RestBadRequestException(String message) {
        super(message);
    }

    public RestBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
