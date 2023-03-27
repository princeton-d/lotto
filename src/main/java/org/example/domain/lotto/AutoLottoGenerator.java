package org.example.domain.lotto;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AutoLottoGenerator implements LottoGenerator {
    private final Random random = new Random();
    
    @Override
    public List<LottoNumber> generate() {
        return random.ints(LottoNumber.NIN_VALUE, LottoNumber.MAX_VALUE + 1) // 지정된 범위 내에서 난수를 생성함
            .distinct() // 중복요소 제거
            .limit(Lotto.NUMBER_SIZE)
            .sorted()
            .mapToObj(number -> new LottoNumber(number))
            .collect(Collectors.toList());
    }
}
