package lotto.domain;

import lotto.constants.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class RandomLottoNumbersGenerateTest {
    @Test
    @DisplayName("생성한 로또 번호는 1~45 사이다.")
    void randomLottoNumberGenerateTest(){
        IntStream.range(0,1000)
                .forEach(i->{
                    List<Integer> generateLottoNumbers = new RandomLottoNumbersGenerate().generateLottoNumber();
                    assertThat(LottoNumbers.LOTTO_NUMBERS.containsAll(generateLottoNumbers)).isTrue();
                });
    }
}