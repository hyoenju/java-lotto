package lotto.view;

import java.util.List;
import lotto.domain.Analyzer;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class ResultView {

    public void printNumberOfLotto(int lottoCounts) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCounts);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printAnalyzeResults(Analyzer analyzer) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printPrizeMoney(Ranking.FIRST, analyzer);
        printPrizeMoney(Ranking.SECOND, analyzer);
        printPrizeMoney(Ranking.THIRD, analyzer);
        printPrizeMoney(Ranking.FOURTH, analyzer);
        printPrizeMoney(Ranking.FIFTH, analyzer);
        printProfitPercent(analyzer.calculateProfitPercent());
    }

    public void printPrizeMoney(Ranking ranking, Analyzer analyzer) {
        StringBuilder sb = new StringBuilder("%d개 일치");
        if (ranking.name().equals(Ranking.SECOND.name())) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(%d원) - %d개%n");
        System.out.printf((sb.toString()), ranking.getNumberOfMatches(), ranking.getPrizeMoney(),
            analyzer.getResultValues(ranking.name()).size());
    }


    public void printProfitPercent(double profitPercent) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitPercent);
    }
}
