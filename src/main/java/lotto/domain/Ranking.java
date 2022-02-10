package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    OTHERS(0, 0, 0);

    private final int numberOfMatches;
    private final int prizeMoney;
    private final int bonus;
    private int count = 0;

    Ranking(final int numberOfMatches, int bonus, final int prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.prizeMoney = prizeMoney;
        this.bonus = bonus;
    }

    public static Ranking of(final int numberOfMatches, final int matchBonusNumber) {
        if (numberOfMatches == SECOND.numberOfMatches && matchBonusNumber == 0) {
            return THIRD;
        }
        return Arrays.stream(values())
            .filter(ranking -> ranking.numberOfMatches == numberOfMatches)
            .findAny()
            .orElse(OTHERS);
    }

    public void addWinningCount() {
        count++;
    }

    public int operate() {
        return prizeMoney * count;
    }


    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getBonus() {
        return bonus;
    }

    public int getCount() {
        return count;
    }
}
