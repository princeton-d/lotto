package org.example.util;

import java.util.ArrayList;
import java.util.List;

public class WritingNumberUtil {
    private static final String DELIMITER = ",";
    private static final int NUMBER_OF_LOTTO = 6;
    
    public List<Integer> createLotto(String lottoNumbers) {
        List<Integer> lotto = new ArrayList<>();
        int[] numberArray = makeNumbersArray(lottoNumbers);
        
        for (int number : numberArray) {
            lotto.add(number);
        }
        
        return lotto;
    }
    
    private int[] makeNumbersArray(String lottoNumbers) {
        String[] splitLottoNumber = lottoNumbers.split(DELIMITER);
        int[] lottoNumber = new int[NUMBER_OF_LOTTO];
        
        for (int i = 0; i < NUMBER_OF_LOTTO; i++) {
            splitLottoNumber[i] = splitLottoNumber[i].trim();
            lottoNumber[i] = Integer.parseInt(splitLottoNumber[i]);
        }
        
        return lottoNumber;
    }
}
