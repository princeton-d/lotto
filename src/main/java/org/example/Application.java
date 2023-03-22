package org.example;

import org.example.domain.lotto.Lotto;
import org.example.domain.money.Money;
import org.example.view.InputView;

import java.math.BigDecimal;
import java.util.List;

public class Application {
    
    private InputView inputView = new InputView();
    
    public void startApplication() {
        int input = inputView.enterPurchaseAmount();
        int numberOfHandwritingLotto = inputView.enterNumberOfHandwritingLotto();
        List<String> pickLottoNumberList = inputView.pickLottoNumber(numberOfHandwritingLotto);
    
        System.out.println(pickLottoNumberList);
        
        BigDecimal amount = new BigDecimal(input);
        Money money = Money.create(amount);
    }
}
