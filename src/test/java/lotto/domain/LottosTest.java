package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.NullAndEmptySource;
//import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    private final List<Lotto> lottos = new ArrayList<>();

    @Test
    @DisplayName("LottoQuantity 와 RandomLottoNumberGenerate 를 전달받아 Lottos 생성")
    void createLottos(){
        LottoQuantity lottoQuantity = new LottoQuantity(2);
        RandomLottoNumbersGenerate randomLottoNumbersGenerate = new RandomLottoNumbersGenerate();

        Lottos createLottos = new Lottos(lottoQuantity,randomLottoNumbersGenerate);

        assertThat(createLottos).isNotNull();
    }
}