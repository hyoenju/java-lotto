package lotto.domain;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void countNumberOfMatchesTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
//        Assertions.assertThat(winningLotto.isContain(3)).isTrue();
    }


    @Test
    void isNotContainTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
//        Assertions.assertThat(winningLotto.isContain(45)).isFalse();
    }

    @Test
    void isEqualBonusNumberTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
//        Assertions.assertThat(winningLotto.isEqualBonusNumber(9)).isTrue();
    }

    @Test
    void isNotEqualBonusNumberTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
//        Assertions.assertThat(winningLotto.isEqualBonusNumber(34)).isFalse();
    }

}