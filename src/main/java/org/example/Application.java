package org.example;

import org.example.domain.money.Money;
import org.example.util.RandomNumberUtil;
import org.example.util.WritingNumberUtil;
import org.example.view.InputView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private RandomNumberUtil randomNumberUtil = new RandomNumberUtil();
    private WritingNumberUtil writingNumberUtil = new WritingNumberUtil();
    private InputView inputView = new InputView();
    
    public void startApplication() {
        int amount = inputView.enterPurchaseAmount();
        int numberOfHandwritingLotto = inputView.enterNumberOfHandwritingLotto();
        Money money = new Money(amount);
        List<List<Integer>> pickLottoList = inputView.pickLottoNumber(numberOfHandwritingLotto, writingNumberUtil);
        int numberOfAutoLotto = money.calculateNumberOfAutoLotto(numberOfHandwritingLotto);
        
        inputView.printResultOfLottoPurchase(numberOfHandwritingLotto, numberOfAutoLotto);
        List<List<Integer>> autoLottoList = this.createAutoLottoNumbers(numberOfAutoLotto);
        
        inputView.printAutoLottoList(autoLottoList);
    
        System.out.println(pickLottoList);
    }
    
    private List<List<Integer>> createAutoLottoNumbers(int numberOfAutoLotto) {
        List<List<Integer>> autoLottoNumberList = new ArrayList<>();
        
        for (int i = 0; i < numberOfAutoLotto; i++) {
            List<Integer> randomNumberLotto = this.randomNumberUtil.create();
            autoLottoNumberList.add(randomNumberLotto);
        }
        
        return autoLottoNumberList;
    }
}