package org.example.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    private LottoGenerator autoGenerator = new AutoLottoGenerator();

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("자동 생성 테스트")
    @Test
    void autoGeneratorTest() {
        assertEquals(6, autoGenerator.generate().size());
    }

    @DisplayName("수동 생성 테스트")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void manualGeneratorTest(List<Integer> list) {
        LottoGenerator manualGenerator = new ManualLottoGenerator(list);
        assertEquals(6, manualGenerator.generate().size());
    }
}