package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView, outputView);

        LottoTickets lottoTickets = lottoController.purchaseLottoTickets();
        lottoController.getWinner(lottoTickets);
    }
}
