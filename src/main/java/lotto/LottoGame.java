package lotto;

import java.util.List;
import lotto.domain.Analyzer;
import lotto.domain.WinningLotto;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        try {
            int payment = inputView.getPayment();
            LottoTickets lottoTickets = new LottoTickets(payment);

            int ticketCounts = lottoTickets.getTicketCounts();

            resultView.printNumberOfLotto(ticketCounts);
            resultView.printLottoTickets(lottoTickets.getLottoTickets());

            List<Integer> winningNumbers = inputView.getWinningNumbers();
            int bonusNumber = inputView.getBonusNumber();

            WinningLotto lottoMachine = new WinningLotto(winningNumbers, bonusNumber);

            List<Integer> numberOfMatches = lottoTickets.countNumberOfMatches(lottoMachine);
            List<Integer> bonusNumbers = lottoTickets.checkBonusNumber(lottoMachine);

            Analyzer analyzer = new Analyzer(payment, numberOfMatches, bonusNumbers);
            resultView.printAnalyzeResults(analyzer.calculateProfitPercent());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}