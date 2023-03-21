package org.example.exception;

public class NumberNotAllowException extends RuntimeException {
    
    public NumberNotAllowException() {
        System.out.println("\n복권은 1000원입니다. 1000원 이상의 금액을 설정해주세요~\n");
    }
}
