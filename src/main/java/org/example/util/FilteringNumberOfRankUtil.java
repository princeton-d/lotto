package org.example.util;

import org.example.domain.rank.Rank;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilteringNumberOfRankUtil {
    private static final int FIRST_RANK_LOTTO_NUMBER_COUNT = 6;
    private static final int SECOND_RANK_LOTTO_NUMBER_COUNT = 7;
    private static final int THIRD_RANK_LOTTO_NUMBER_COUNT = 5;
    private static final int FOURTH_RANK_LOTTO_NUMBER_COUNT = 4;
    private static final int FIFTH_RANK_LOTTO_NUMBER_COUNT = 3;
    
    private FilteringNumberOfRankUtil() {
    }
    
    public static Map<Rank, Integer> FilteringRank(List<Integer> result) {
        Map<Rank, Integer> ranks = new HashMap<>();
        Integer first = Collections.frequency(result, FIRST_RANK_LOTTO_NUMBER_COUNT);
        Integer second = Collections.frequency(result, SECOND_RANK_LOTTO_NUMBER_COUNT);
        Integer third = Collections.frequency(result, THIRD_RANK_LOTTO_NUMBER_COUNT);
        Integer fourth = Collections.frequency(result, FOURTH_RANK_LOTTO_NUMBER_COUNT);
        Integer fifth = Collections.frequency(result, FIFTH_RANK_LOTTO_NUMBER_COUNT);
        
        ranks.put(Rank.FIRST, first);
        ranks.put(Rank.SECOND, second);
        ranks.put(Rank.THIRD, third);
        ranks.put(Rank.FOURTH, fourth);
        ranks.put(Rank.FIFTH, fifth);
    
        return ranks;
    }
}
