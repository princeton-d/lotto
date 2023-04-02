package org.example.domain.rank;

import java.math.BigDecimal;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);
    
    
    private final int matching;
    private final BigDecimal reward;
    
    Rank(int matching, int reward) {
        this.matching = matching;
        this.reward = new BigDecimal(reward);
    }
}
