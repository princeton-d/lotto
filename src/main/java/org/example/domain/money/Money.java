package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static final int PRICE_OF_LOTTO = 1000;
    private static BigDecimal value;
    
    private Money(BigDecimal value) {
        this.value = value;
    }
    
    public static Money create(BigDecimal value) {
        return new Money(value);
    }
    
    public int calculateNumberOfAutoLotto(int numberOfHandwritingLotto) {
        int handwritingLottoPrice = numberOfHandwritingLotto * PRICE_OF_LOTTO;
        int breakMoney = value.intValue() - handwritingLottoPrice;
        int numberOfAutoLotto = (int) Math.floor(breakMoney / PRICE_OF_LOTTO);
    
        return numberOfAutoLotto;
    }
}
