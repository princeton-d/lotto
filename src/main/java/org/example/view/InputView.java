package org.example.view;

import org.example.exception.NumberNotAllowException;

import java.util.Scanner;

public class InputView {
    private static final int PRICE_OF_LOTTO = 1000; // 일단 여기 만들어둠.
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public int enterPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        
        int amount = SCANNER.nextInt();
    
        try {
            validateAmount(amount);
        } catch (NumberNotAllowException e) {
            enterPurchaseAmount();
        }
        
        return amount;
    }
    
    private void validateAmount(int amount) {
        if (amount < PRICE_OF_LOTTO) {
            throw new NumberNotAllowException();
        }
    }
}