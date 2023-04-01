package org.example.domain.money;

import java.math.BigDecimal;

public class Money {
    private static final BigDecimal PRICE_OF_LOTTO = new BigDecimal(1000); // 1000이라는 int 형이 아닌 value 와 연산하기 쉽도록 BigDecimal 형태로 생성
    private final BigDecimal principal;
    private BigDecimal value; // value 값에 static 을 붙이면 객체를 생성하기 이전에 이미 할당이 되어버림, 원하는 모습이 아니다.
    
    public Money(int amount) {
        BigDecimal value = new BigDecimal(amount);
        validatePrincipal(value);
        this.principal = value;
        this.value = value;
    }
    
    public void buyLotto(int lottoCount) { // 구매하려는 로또의 종류가 자동인지 수동인지 관여할 필요 없음, 구매만 하는 역할을 부여해야함.
        BigDecimal lottoPrice = PRICE_OF_LOTTO.multiply(new BigDecimal(lottoCount));
        validateCanAfford(lottoPrice, this.value);
        this.value = value.subtract(lottoPrice);
    }
    
    public int countPurchasableLotto() {
        return value.divide(PRICE_OF_LOTTO).intValue();
    }
    
    public BigDecimal getPrincipal() {
        return principal;
    }
    
    private void validatePrincipal(BigDecimal principal) {
        if (principal.compareTo(PRICE_OF_LOTTO) == -1) {
            throw new IllegalArgumentException("로또의 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }
    
    private void validateCanAfford(BigDecimal lottoPrice, BigDecimal remainingMoney) {
        if (remainingMoney.compareTo(lottoPrice) == -1) {
            throw new IllegalArgumentException("현재 금액보다 많은 수의 로또를 구매하려고 했습니다. 구매할 수 없습니다.");
        }
    }
}
