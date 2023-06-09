package org.example.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers;
    
    public ManualLottoGenerator(List<Integer> number) {
        this.numbers = number;
    }
    
    @Override
    public List<LottoNumber> generate() {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
