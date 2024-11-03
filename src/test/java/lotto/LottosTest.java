package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void Lottos_생성() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        Lottos lottos = new Lottos(List.of(lotto));

        assertThat(lottos).isEqualTo(new Lottos(List.of(lotto)));
    }

    @Test
    void 모든_로또_출력() {
        Lotto lotto1 = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        Lotto lotto2 = new Lotto(
                List.of(LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9), LottoNumber.from(10),
                        LottoNumber.from(11), LottoNumber.from(12)));

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }

    @Test
    void 로또_번호_일치_개수_구하기() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        Lottos lottos = new Lottos(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto("1,2,3,7,8,9", "10");
        assertThat(lottos.calculateWinnings(lotto, winningLotto)).isEqualTo(3);
    }

    @Test
    void 보너스_번호_일치_여부_확인() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        Lottos lottos = new Lottos(List.of(lotto));

        WinningLotto winningLotto1 = new WinningLotto("1,2,3,4,5,7", "6");
        WinningLotto winningLotto2 = new WinningLotto("1,2,3,4,5,7", "45");

        assertThat(lottos.hasBonus(lotto, winningLotto1)).isTrue();
        assertThat(lottos.hasBonus(lotto, winningLotto2)).isFalse();
    }

    @Test
    void Lottos_크기_확인() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4),
                        LottoNumber.from(5), LottoNumber.from(6)));
        Lottos lottos = new Lottos(List.of(lotto));

        assertThat(lottos.size()).isEqualTo(1);
    }
}
