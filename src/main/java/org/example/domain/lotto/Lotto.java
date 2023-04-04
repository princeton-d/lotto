package org.example.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    
    List<LottoNumber> lottoNumbers;
    
    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers = lottoGenerator.generate();
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (LottoNumber number : this.lottoNumbers) {
            lottoNumbers.add(number.getNumber());
        }

        return lottoNumbers;
    }
    
    public boolean isBonusMatched(int bonusNumber) {
        return getLottoNumbers().contains(bonusNumber);
    }
}
