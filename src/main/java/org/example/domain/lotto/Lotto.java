package org.example.domain.lotto;

import java.util.List;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    
    List<LottoNumber> lottoNumbers;
    
    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers = lottoGenerator.generate();
    }
    
    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottoNumbers.forEach(item -> sb.append(item.toString()).append(" "));
        return sb.toString();
    }
}
