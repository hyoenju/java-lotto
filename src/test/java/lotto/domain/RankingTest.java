package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void enum_2등_반환_테스트() {
        Ranking ranking = Ranking.of(5, true);
        Assertions.assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @Test
    void enum_3등_반환_테스트() {
        Ranking ranking = Ranking.of(5, false);
        Assertions.assertThat(ranking).isEqualTo(Ranking.THIRD);
    }
}
