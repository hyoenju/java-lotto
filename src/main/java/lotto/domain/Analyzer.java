package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {

    private final double payment;
    private final Map<String, List<Integer>> winningResults;

    public Analyzer(final int payment, final List<Integer> numberOfMatches,
        final List<Boolean> bonusNumbers) {
        this.payment = payment;
        this.winningResults = countWinningResults(numberOfMatches, bonusNumbers);
    }

    private Map<String, List<Integer>> countWinningResults(
        final List<Integer> numberOfMatches, final List<Boolean> bonusNumbers) {

        Map<String, List<Integer>> winningResults = new HashMap<>();

        for (int i = 0; i < numberOfMatches.size(); i++) {
            int match = numberOfMatches.get(i);
            boolean bonus = bonusNumbers.get(i);

            Ranking rank = Ranking.of(match, bonus);

            List<Integer> result = winningResults.getOrDefault(rank.name(), new ArrayList<>());
            result.add(rank.getPrizeMoney());

            winningResults.put(rank.name(), result);
        }
        System.out.println(winningResults);
        return winningResults;
    }

    public double calculateProfitPercent() {
        return sumTotalPrizeMoney() / payment;
    }

    private int sumTotalPrizeMoney() {
        return winningResults.values().stream()
            .map(values -> values.stream().mapToInt(Integer::intValue).sum())
            .mapToInt(Integer::intValue).sum();
    }

    public List<Integer> getResultValues(String name) {
        if (!this.winningResults.containsKey(name)) {
            return new ArrayList<>();
        }
        return this.winningResults.get(name);
    }
}
