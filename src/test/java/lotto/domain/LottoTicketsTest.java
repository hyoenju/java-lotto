package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 로또_장당_당첨번호_개수_일치여부_테스트() {

        LottoTickets lottoTickets = new LottoTickets(
            Arrays.asList(
                new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList())),
                new Lotto(Stream.of(5, 6, 7, 8, 9, 10)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()))
            )
        );
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 8);
        List<Integer> correctWinNumbers = winningLotto.countNumberOfMatches(lottoTickets);
        Assertions.assertThat(correctWinNumbers.get(0)).isEqualTo(6);
        Assertions.assertThat(correctWinNumbers.get(1)).isEqualTo(2);
    }

    @Test
    void 로또_장당_보너스_개수_일치여부_테스트() {
        LottoTickets lottoTickets = new LottoTickets(
            Arrays.asList(
                new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList())),
                new Lotto(Stream.of(5, 6, 7, 8, 9, 10)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()))
            )
        );

        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 8);
        List<Boolean> checkBonusNumber = winningLotto.hasBonusNumbers(lottoTickets);

        Assertions.assertThat(checkBonusNumber.get(0)).isFalse();
        Assertions.assertThat(checkBonusNumber.get(1)).isTrue();
    }
}
