package com.demo.management.exceptions;

public class ManagementException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ManagementException(String message) {
        super(message);
    }
}
