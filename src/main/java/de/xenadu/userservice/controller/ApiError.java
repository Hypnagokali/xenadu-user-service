package de.xenadu.userservice.controller;

import lombok.Getter;

@Getter
public class ApiError {

    private int status;
    private String message;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
