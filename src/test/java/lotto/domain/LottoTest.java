package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    public void 다른_로또와_번호_일치_개수를_반환함() {
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto otherLotto = new Lotto(Stream.of(3, 4, 5, 6, 7, 8)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Assertions.assertThat(lotto.matchCount(otherLotto)).isEqualTo(4);
    }

    @Test
    public void 로또_안에_특정_번호가_있는지_여부를_반환함() {
        Lotto lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Assertions.assertThat(lotto.contains(new LottoNumber(1))).isTrue();
    }
}