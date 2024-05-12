package com.nps.exception;

public class ProductNotFoundException extends Exception {
    private Long id;
    private String message;

    public ProductNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
}
