package org.example.exception;

public class NotAllowNumberException extends RuntimeException {
    
    public NotAllowNumberException(String e) {
        super(e);
        System.out.println(getMessage());
    }
}
