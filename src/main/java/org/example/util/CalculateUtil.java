package org.example.util;

import org.example.domain.result.Result;

import java.math.BigDecimal;
import java.util.Map;

public class CalculateUtil {
    private static final BigDecimal NUM = new BigDecimal(100);
    
    private CalculateUtil() {
    }

    public static BigDecimal calculateRateOfReturn(BigDecimal baseMoney, BigDecimal profit) {
        return (profit.subtract(baseMoney)).divide(baseMoney).multiply(NUM);
    }

    public static BigDecimal calculateProfit(Result rankList) {
        BigDecimal profit = new BigDecimal(5000);

        for (Map.Entry<BigDecimal, BigDecimal> entrySet : rankList.getResult().entrySet()) {
            BigDecimal reward = entrySet.getKey().multiply(entrySet.getValue());
            profit = profit.add(reward);
        }
    
        return profit;
    }
}
