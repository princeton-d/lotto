package org.example;

import org.example.exception.NumberNotAllowException;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Application {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    
    public void startApplication() {
        int amount = inputView.enterPurchaseAmount(outputView);
        if (amount < 1000) {
            throw new NumberNotAllowException();
        }
    }
}
