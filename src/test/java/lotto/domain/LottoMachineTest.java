package lotto.domain;


import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void isContainTest() {
        WinningLotto lottoMachine = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isContain(3)).isTrue();
    }


    @Test
    void isNotContainTest() {
        WinningLotto lottoMachine = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isContain(45)).isFalse();
    }

    @Test
    void isEqualBonusNumberTest() {
        WinningLotto lottoMachine = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(9)).isTrue();
    }

    @Test
    void isNotEqualBonusNumberTest() {
        WinningLotto lottoMachine = new WinningLotto(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(34)).isFalse();
    }

}