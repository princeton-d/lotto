package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static BigDecimal value;
    
    private Money(BigDecimal value) {
        this.value = value;
    }
    
    public static Money create(BigDecimal value) {
        return new Money(value);
    }
}
