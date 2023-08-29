package lotto.domain;

import lotto.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class RandomLottoConstantsGenerateTest {
    @Test
    @DisplayName("생성한 로또 번호는 1~45 사이다.")
    void randomLottoNumberGenerateTest(){
        IntStream.range(0,1000)
                .forEach(i->{
                    Set<Integer> generateLottoNumbers = new RandomLottoNumbersGenerate().generateLottoNumber();
                    assertThat(LottoConstants.LOTTO_NUMBERS.containsAll(generateLottoNumbers)).isTrue();
                });
    }
}