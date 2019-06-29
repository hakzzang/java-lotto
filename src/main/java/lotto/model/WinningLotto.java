package lotto.model;

import lotto.exception.ConflictLottoNumberException;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new ConflictLottoNumberException();
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Prize matches(Lotto lotto) {
        int countOfMatchingNumbers = this.lotto.getCountOfMatchingNumbers(lotto);
        boolean hasBonusNumber = lotto.contains(this.bonusNumber);

        return Prize.valueOf(countOfMatchingNumbers, hasBonusNumber);
    }
}