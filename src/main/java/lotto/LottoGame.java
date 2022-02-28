package lotto;

import java.util.List;
import lotto.domain.Payment;
import lotto.domain.Analyzer;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        try {
            Payment payment = new Payment(inputView.getPayment());
            resultView.printNumberOfLotto(payment.numberOfPurchases);

            LottoTickets lottoTickets = new LottoTickets(payment.numberOfPurchases);

            for (Lotto lotto : lottoTickets.getLottoTickets()) {
                System.out.println(lotto);
            }
            WinningLotto winningLotto = new WinningLotto(inputView.getWinningNumbers(),
                inputView.getBonusNumber());
//
            List<Integer> numberOfMatches = winningLotto.countNumberOfMatches(lottoTickets);
            List<Boolean> bonusNumbers = winningLotto.hasBonusNumbers(lottoTickets);
//
//            System.out.println(numberOfMatches);
//            System.out.println(bonusNumbers);
////
//            Ranking.of(match, bonus).getPrizeMoney();

//            System.out.println(lotto);/
//            LottoTickets lottoTickets = new LottoTickets(payment);
//
//            int ticketCounts = lottoTickets.getTicketCounts();
//
//            resultView.printNumberOfLotto(ticketCounts);
//            resultView.printLottoTickets(lottoTickets.getLottoTickets());
//
//            List<Integer> winningNumbers = inputView.getWinningNumbers();
//            int bonusNumber = inputView.getBonusNumber();
//
//            WinningLotto lottoMachine = new WinningLotto(winningNumbers, bonusNumber);
//
//            List<Integer> numberOfMatches = lottoTickets.countNumberOfMatches(lottoMachine);
//            List<Integer> bonusNumbers = lottoTickets.checkBonusNumber(lottoMachine);
//
            Analyzer analyzer = new Analyzer(payment.paymentAmount, numberOfMatches, bonusNumbers);
            resultView.printAnalyzeResults(analyzer);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}