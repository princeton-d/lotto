package org.example.util;

import org.example.domain.rank.Rank;
import org.example.domain.result.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class CalculateUtil {
    private static final int NUM = 100;
    
    private CalculateUtil() {
    }

    public static BigDecimal calculateRateOfReturn(BigDecimal baseMoney, BigDecimal profit) {
        return (profit.subtract(baseMoney)).divide(baseMoney, RoundingMode.DOWN).multiply(new BigDecimal(NUM));
    }

    public static BigDecimal calculateProfit(Result rankList) {
        BigDecimal profit = new BigDecimal(0);

        for (Map.Entry<Rank, Integer> entrySet : rankList.getResult().entrySet()) {
            Rank prizeMoney = entrySet.getKey();
            int rewardCount = entrySet.getValue();
            boolean zeroRewardState = isValidateZeroNumber(rewardCount);
            
            BigDecimal reward = calculationReward(zeroRewardState, prizeMoney, rewardCount);
            
            profit = profit.add(reward);
        }
    
        return profit;
    }
    
    private static boolean isValidateZeroNumber(int number) {
        if (number == 0) {
            return true;
        }
    
        return false;
    }
    
    private static BigDecimal calculationReward(boolean zeroRewardState, Rank prizeMoney, Integer rewardCount) {
        if (zeroRewardState) {
            return new BigDecimal(0);
        }
        
        return prizeMoney.getReward().multiply(new BigDecimal(rewardCount));
    }
}
