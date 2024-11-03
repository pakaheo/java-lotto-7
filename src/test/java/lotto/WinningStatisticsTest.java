package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    void 당첨_현황() {
        WinningRank.match(3, false);
        WinningRank.match(5, true);

        assertThat(WinningStatistics.winningStatus()).isEqualTo("3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 0개");
    }
}
