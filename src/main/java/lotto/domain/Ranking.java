package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    OTHERS(0, false, 0);

    private final int numberOfMatches;
    private final int prizeMoney;
    private final boolean bonus;

    Ranking(final int numberOfMatches, boolean bonus, final int prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public static Ranking of(final int numberOfMatches, final boolean matchBonusNumber) {
        if (numberOfMatches == SECOND.numberOfMatches && !matchBonusNumber) {
            return THIRD;
        }
        return Arrays.stream(values())
            .filter(ranking -> ranking.numberOfMatches == numberOfMatches)
            .findAny()
            .orElse(OTHERS);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
