package org.example.exception;

public class NumberNotAllowException extends RuntimeException {


    public NumberNotAllowException(String message) {
        super(message);
    }
}