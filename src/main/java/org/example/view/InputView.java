package org.example.view;

import org.example.exception.NumberNotAllowException;

import java.util.ArrayList;
import java.util.List;
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
    
    public int enterNumberOfHandwritingLotto() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int numberOfHandwritingLotto = SCANNER.nextInt();
        SCANNER.nextLine(); // 버퍼 리셋
        
        return numberOfHandwritingLotto;
    }
    
    public List<String> pickLottoNumber(int numberOfHandWritingLotto) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottoList = new ArrayList<>();
        
        for (int i = 0; i < numberOfHandWritingLotto; i++) {
            String lotto = SCANNER.nextLine();
            lottoList.add(lotto);
        }
        
        return lottoList;
    }
    
    private void validateAmount(int amount) {
        if (amount < PRICE_OF_LOTTO) {
            throw new NumberNotAllowException();
        }
    }
}