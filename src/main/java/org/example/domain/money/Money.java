package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static final BigDecimal PRICE_OF_LOTTO = new BigDecimal(1000);
    private BigDecimal value;

    public Money(int amount) {
        BigDecimal value = new BigDecimal(amount);
        this.value = value;
    }

    public void buyLotto(int numberOfLotto) {
        BigDecimal lottoPrice = PRICE_OF_LOTTO.multiply(new BigDecimal(numberOfLotto));
        value = value.subtract(lottoPrice);
    }

    public int countPurchasableLotto() {
        return value.divide(PRICE_OF_LOTTO).intValue(); // FIXME 더 좋은 방법으로 개선
    }
}