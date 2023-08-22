package lotto.controller;

import lotto.constants.LottoConstants;
import lotto.domain.*;
import lotto.dto.LottoDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoController {
    private final RandomLottoNumbersGenerate randomLottoNumbersGenerate;

    public LottoController(RandomLottoNumbersGenerate randomLottoNumbersGenerate) {
        this.randomLottoNumbersGenerate = randomLottoNumbersGenerate;
    }

    public void start(){
        InputMoney inputMoney = getInputMoney();
        LottoQuantity lottoQuantity = getLottoQuantityByInputMoney(inputMoney);
        OutputView.printLottoQuantity(lottoQuantity.getLottoQuantity());

        Lottos autoLottos = new Lottos(lottoQuantity, randomLottoNumbersGenerate);
        List<LottoDTO> lottoDTOs = autoLottos.getLottos()
                .stream()
                .map(LottoDTO::new)
                .collect(Collectors.toList());
        OutputView.printLottos(lottoDTOs);

        WinningLotto winningLotto = setupWinningLotto();

    }

    private InputMoney getInputMoney(){
        try {
            return new InputMoney(InputView.scanInputMoney());
        } catch (IllegalArgumentException exception){
            OutputView.printException(exception);
            return getInputMoney();
        }
    }

    private LottoQuantity getLottoQuantityByInputMoney(InputMoney inputMoney){
        return new LottoQuantity(inputMoney.getMoney() / LottoConstants.LOTTI_SINGLE_PRICE);
    }
    private WinningLotto setupWinningLotto() {
        Lotto lotto = generateLotto();
        int bonusNumber = generateBonusNumber();

        try {
            return new WinningLotto(lotto,bonusNumber);
        } catch (IllegalArgumentException exception){
            OutputView.printException(exception);
            return setupWinningLotto();
        }
    }

    private Lotto generateLotto(){
        try{
            List<Integer> winningNumberValues = InputView.scanWinningNumber();
            Set<Integer> lottoNumbers = new HashSet<>(winningNumberValues);
            return new Lotto(lottoNumbers);
        } catch (IllegalArgumentException exception){
            OutputView.printException(exception);
            return generateLotto();
        }
    }

    private int generateBonusNumber(){
        try{
            return InputView.scanBonusNumber();
        } catch (IllegalArgumentException exception){
            OutputView.printException(exception);
            return generateBonusNumber();
        }
    }
}
