package org.example.domain.result;

public enum Rank {
    MATCH_THREE_NUMBERS(5), MATCH_FOUR_NUMBERS(4), MATCH_FIVE_NUMBER(3), MATCH_FIVE_NUMBERS_AND_BONUS_BALL(2), MATCH_SIX_NUMBERS(1);

    final private int rank;

    private Rank(int rank) {
        this.rank = rank;
    }
}
