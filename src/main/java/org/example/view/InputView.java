package org.example.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public int enterPurchaseAmount(OutputView outputView) {
        outputView.printPurchaseAmountGuide();
        String input = SCANNER.nextLine();
        int amount = Integer.parseInt(input);
        
        return amount;
    }
}
