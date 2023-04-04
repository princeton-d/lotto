package org.example.domain.result;

import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoList;
import org.example.domain.lotto.LottoNumber;
import org.example.domain.rank.Rank;
import org.example.util.FilteringNumberOfRankUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Result {
    private Map<Rank, Integer> rankList;
    
    
    public Result(LottoList lottoList, Lotto winningNumbers, LottoNumber bonusBallNumber) {
        this.rankList = createResult(lottoList, winningNumbers, bonusBallNumber);
    }
    
    private Map<Rank, Integer> createResult(LottoList lottoList, Lotto winningNumbers, LottoNumber bonusBallNumber) {
        List<Lotto> lottos = lottoList.getLottoList();
        List<Integer> winning = winningNumbers.getLottoNumbers();
        int bonusBall = bonusBallNumber.getNumber();
        List<Integer> resultList = new ArrayList<>();
        
        for (Lotto lotto : lottos) {
            List<Integer> duplicateLottoNumber = new ArrayList<>();
            boolean isBonus = lotto.isBonusMatched(bonusBall);
            duplicateLottoNumber.addAll(lotto.getLottoNumbers());
            duplicateLottoNumber.retainAll(winning);
            int duplicateLottoCount = duplicateLottoNumber.size();
            int rank = checkedRank(duplicateLottoCount, isBonus);
            
            resultList.add(rank);
        }
        
        Map<Rank, Integer> rankList = FilteringNumberOfRankUtil.FilteringRank(resultList);
        
        return rankList;
    }
    
    private int checkedRank(int duplicateLottoCount, boolean isBonus) {
        if (duplicateLottoCount == 5 && isBonus) {
            return 7;
        }
        
        return duplicateLottoCount;
    }
    
    public Map<Rank, Integer> getResult() {
        return rankList;
    }
}
