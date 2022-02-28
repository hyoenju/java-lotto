package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        this.bonusNumber = new LottoNumber(bonusNumber);
        System.out.println(winningLotto.contains(this.bonusNumber));
    }

    public List<Integer> countNumberOfMatches(LottoTickets lottoTickets) {
        List<Integer> correctNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            correctNumbers.add(winningLotto.matchCount(lotto));
        }
        return correctNumbers;
    }

    public List<Boolean> hasBonusNumbers(LottoTickets lottoTickets) {
        List<Boolean> bonusNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            bonusNumbers.add(lotto.contains(bonusNumber));
        }
        return bonusNumbers;
    }
}

//    보너스 볼과 winningNumbers 의 숫자가 겹치는 경우


//    public boolean isContain(int number) {
//        return winningNumbers.contains(number);
//    }
//
//    public boolean isEqualBonusNumber(final int number) {
//        return bonusNumber == number;
//    }
