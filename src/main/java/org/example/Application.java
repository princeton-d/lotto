package org.example;

import org.example.domain.money.Money;
import org.example.view.InputView;

import java.math.BigDecimal;

public class Application {
    
    private InputView inputView = new InputView();
    
    public void startApplication() {
            int input = inputView.enterPurchaseAmount();
            BigDecimal amount = new BigDecimal(input);
            Money money = Money.create(amount);
    }
}
