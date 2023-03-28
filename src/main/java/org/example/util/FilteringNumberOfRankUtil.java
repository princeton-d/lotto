package org.example.util;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilteringNumberOfRankUtil {
    private static final int FIRST_RANK_NUMBER_OF_LOTTO = 6;
    private static final BigDecimal FIRST_RANK_REWARD = new BigDecimal(2000000000);
    private static final int SECOND_RANK_NUMBER_OF_LOTTO = 7;
    private static final BigDecimal SECOND_RANK_REWARD = new BigDecimal(30000000);
    private static final int THIRD_RANK_NUMBER_OF_LOTTO = 5;
    private static final BigDecimal THIRD_RANK_REWARD = new BigDecimal(1500000);
    private static final int FOURTH_RANK_NUMBER_OF_LOTTO = 4;
    private static final BigDecimal FOURTH_RANK_REWARD = new BigDecimal(50000);
    private static final int FIFTH_RANK_NUMBER_OF_LOTTO = 3;
    private static final BigDecimal FIFTH_RANK_REWARD = new BigDecimal(5000);
    
    private FilteringNumberOfRankUtil() {
    }
    
    public static Map<BigDecimal, BigDecimal> FilteringRank(List<Integer> result) {
        Map<BigDecimal, BigDecimal> ranks = new HashMap<>();
        BigDecimal first = new BigDecimal(Collections.frequency(result, FIRST_RANK_NUMBER_OF_LOTTO));
        final BigDecimal firstReward = FIRST_RANK_REWARD;
        BigDecimal second = new BigDecimal(Collections.frequency(result, SECOND_RANK_NUMBER_OF_LOTTO));
        final BigDecimal secondReward = SECOND_RANK_REWARD;
        BigDecimal third = new BigDecimal(Collections.frequency(result, THIRD_RANK_NUMBER_OF_LOTTO));
        final BigDecimal thirdReward = THIRD_RANK_REWARD;
        BigDecimal fourth = new BigDecimal(Collections.frequency(result, FOURTH_RANK_NUMBER_OF_LOTTO));
        final BigDecimal fourthReward = FOURTH_RANK_REWARD;
        BigDecimal fifth = new BigDecimal(Collections.frequency(result, FIFTH_RANK_NUMBER_OF_LOTTO));
        final BigDecimal fifthReward = FIFTH_RANK_REWARD;
        
        ranks.put(firstReward, first);
        ranks.put(secondReward, second);
        ranks.put(thirdReward, third);
        ranks.put(fourthReward, fourth);
        ranks.put(fifthReward, fifth);
    
        return ranks;
    }
}
