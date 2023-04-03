package org.example.util;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilteringNumberOfRankUtil {
    private static final int FIRST_RANK_LOTTO_NUMBER_COUNT = 6;
    private static final BigDecimal FIRST_RANK_REWARD = new BigDecimal(2000000000);
    private static final int SECOND_RANK_LOTTO_NUMBER_COUNT = 7;
    private static final BigDecimal SECOND_RANK_REWARD = new BigDecimal(30000000);
    private static final int THIRD_RANK_LOTTO_NUMBER_COUNT = 5;
    private static final BigDecimal THIRD_RANK_REWARD = new BigDecimal(1500000);
    private static final int FOURTH_RANK_LOTTO_NUMBER_COUNT = 4;
    private static final BigDecimal FOURTH_RANK_REWARD = new BigDecimal(50000);
    private static final int FIFTH_RANK_LOTTO_NUMBER_COUNT = 3;
    private static final BigDecimal FIFTH_RANK_REWARD = new BigDecimal(5000);
    
    private FilteringNumberOfRankUtil() {
    }
    
    public static Map<BigDecimal, Integer> FilteringRank(List<Integer> result) {
        Map<BigDecimal, Integer> ranks = new HashMap<>();
        Integer first = Collections.frequency(result, FIRST_RANK_LOTTO_NUMBER_COUNT);
        final BigDecimal firstReward = FIRST_RANK_REWARD;
        Integer second = Collections.frequency(result, SECOND_RANK_LOTTO_NUMBER_COUNT);
        final BigDecimal secondReward = SECOND_RANK_REWARD;
        Integer third = Collections.frequency(result, THIRD_RANK_LOTTO_NUMBER_COUNT);
        final BigDecimal thirdReward = THIRD_RANK_REWARD;
        Integer fourth = Collections.frequency(result, FOURTH_RANK_LOTTO_NUMBER_COUNT);
        final BigDecimal fourthReward = FOURTH_RANK_REWARD;
        Integer fifth = Collections.frequency(result, FIFTH_RANK_LOTTO_NUMBER_COUNT);
        final BigDecimal fifthReward = FIFTH_RANK_REWARD;
        
        ranks.put(firstReward, first);
        ranks.put(secondReward, second);
        ranks.put(thirdReward, third);
        ranks.put(fourthReward, fourth);
        ranks.put(fifthReward, fifth);
    
        return ranks;
    }
}
