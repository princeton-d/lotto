package org.example.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    
    List<LottoNumber> lottoNumbers;
    
    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers = lottoGenerator.generate();
    }
    
    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public List<Integer> getLottoNumbersArray() {
        List<Integer> lottoNumberArray = new ArrayList<>();

        for (LottoNumber number : this.lottoNumbers) {
            lottoNumberArray.add(number.getNumber());
        }

        return lottoNumberArray;
    }
}
