package com.example.transaction_demo_propagation_rollback.exception;

public class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}