package org.example.domain.result;

import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoList;
import org.example.domain.winning_number.BonusBallNumber;
import org.example.domain.winning_number.WinningNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    /**
     * 1. 로또번호에 보너스볼 있는지 유무 contains 사용해 boolean 값으로 저장
     * 2. 로또번호 + 당첨결과 indexOf 와 lastIndexOf 를 사용해 중복된 것만 hashSet 에 저장.
     */
    Rank firstRank = Rank.MATCH_SIX_NUMBERS;
    Rank secondRank = Rank.MATCH_FIVE_NUMBERS_AND_BONUS_BALL;
    Rank thirdRank = Rank.MATCH_FIVE_NUMBER;
    Rank fourthRank = Rank.MATCH_FOUR_NUMBERS;
    Rank fifthRank = Rank.MATCH_THREE_NUMBERS;
    private final int result;

    private Result() {
        this.result = 1;
    }

    public Result createResult(LottoList lottoList, WinningNumbers winningNumbers, BonusBallNumber bonusBallNumber) {
        List<Lotto> lottos = lottoList.getLottoList();
        List<Integer> rankList = new ArrayList<>();

        for (Lotto lotto : lottos) {

        }

        return new Result();
    }
}
