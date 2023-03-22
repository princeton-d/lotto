package org.example;

import org.example.domain.money.Money;
import org.example.view.InputView;

import java.math.BigDecimal;
import java.util.List;

public class Application {
    
    private InputView inputView = new InputView();
    
    public void startApplication() {
        int input = inputView.enterPurchaseAmount();
        int numberOfHandwritingLotto = inputView.enterNumberOfHandwritingLotto();
        Money money = Money.create(new BigDecimal(input));
        List<String> pickLottoNumberList = inputView.pickLottoNumber(numberOfHandwritingLotto);
        int numberOfAutoLotto = money.calculateNumberOfAutoLotto(numberOfHandwritingLotto);
        inputView.printResultOfLottoPurchase(numberOfHandwritingLotto, numberOfAutoLotto);
    }
}
