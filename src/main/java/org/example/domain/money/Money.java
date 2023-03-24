package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static final int PRICE_OF_LOTTO = 1000;
    private static BigDecimal value;
    
    public Money(int amount) {
        BigDecimal value = new BigDecimal(amount);
        this.value = value;
    }
    
    public int calculateNumberOfAutoLotto(int numberOfHandwritingLotto) {
        int handwritingLottoPrice = numberOfHandwritingLotto * PRICE_OF_LOTTO;
        int breakMoney = value.intValue() - handwritingLottoPrice;
        int numberOfAutoLotto = (int) Math.floor(breakMoney / PRICE_OF_LOTTO);
    
        return numberOfAutoLotto;
    }
}
