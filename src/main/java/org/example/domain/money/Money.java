package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static final BigDecimal PRICE_OF_LOTTO = new BigDecimal(1000); // 1000이라는 int 형이 아닌 value 와 연산하기 쉽도록 BigDecimal 형태로 생성
    private final BigDecimal baseMoney;
    private BigDecimal value; // value 값에 static 을 붙이면 객체를 생성하기 이전에 이미 할당이 되어버림, 원하는 모습이 아니다.
    
    public Money(int amount) {
        BigDecimal value = new BigDecimal(amount);
        this.baseMoney = value;
        this.value = value;
    }
    
    public void buyLotto(int numberOfLotto) { // 구매하려는 로또의 종류가 자동인지 수동인지 관여할 필요 없음, 구매만 하는 역할을 부여해야함.
        BigDecimal lottoPrice = PRICE_OF_LOTTO.multiply(new BigDecimal(numberOfLotto));
        this.value = value.subtract(lottoPrice);
    }
    
    public int countPurchasableLotto() {
        return value.divide(PRICE_OF_LOTTO).intValue(); // FIXME 더 좋은 방법으로 개선
    }
    
    public BigDecimal getBaseMoney() {
        return baseMoney;
    }
}
