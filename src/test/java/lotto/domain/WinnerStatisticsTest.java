package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerStatisticsTest {
    @DisplayName("1등 1개, 2등 1개, 꽝 1개")
    @Test
    void getResult() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        EnumMap<Rank, Integer> result = winnerStatistics.getResults();

        // then
        assertThat(result.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.SECOND, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.NONE, 0)).isEqualTo(1);
    }

    @DisplayName("3개 구입하여 1등 1개, 2등 1개일 때 수익률을 확인")
    @Test
    void getEarningRateTest() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        double earningRate = winnerStatistics.getEarningRate(3000);

        // then
        assertThat(earningRate).isEqualTo(676666.66);
    }

    private WinnerStatistics createWinnerStatistics() {
        LottoTicket winningTicket = createWinningTicket();
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        List<LottoTicket> pickedLottoTickets = new ArrayList<>(createPickedTickets());
        return new WinnerStatistics(goldenTicket, pickedLottoTickets);
    }

    private LottoTicket createWinningTicket() {
        List<LottoNumber> lottoNumbersList = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        return new LottoTicket(lottoNumbersList);
    }

    private List<LottoTicket> createPickedTickets() {
        List<LottoNumber> lottoNumberList = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        List<LottoNumber> lottoNumberList2 = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43),
                new LottoNumber(45)
        );
        List<LottoNumber> lottoNumberList3 = Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(8),
                new LottoNumber(27),
                new LottoNumber(30),
                new LottoNumber(35),
                new LottoNumber(44)
        );
        LottoTicket lottoTicket = new LottoTicket(lottoNumberList);
        LottoTicket lottoTicket2 = new LottoTicket(lottoNumberList2);
        LottoTicket lottoTicket3 = new LottoTicket(lottoNumberList3);
        return Arrays.asList(
                lottoTicket, lottoTicket2, lottoTicket3
        );
    }
}