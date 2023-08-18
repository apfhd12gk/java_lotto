package lotto.dto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoDTOTest {
    private Lotto lotto;

    @BeforeEach
    void setUp(){
        Set<Integer> lottoNumbers = Set.of(7,10,3,42,5,25);

        lotto = new Lotto(lottoNumbers);
    }
    @Test
    @DisplayName("LottoDTO 생성 테스트")
    void createLottoDTO(){
        LottoDTO lottoDTO = new LottoDTO(lotto);

        assertThat(lottoDTO).isNotNull();

    }

    @Test
    @DisplayName("getLottos 는 크기가 6인 List<Integer>를 반환한다.")
    void getLotto(){
        // given
        LottoDTO lottoDTO = new LottoDTO(lotto);

        // when
        List<Integer> actual = lottoDTO.getLottoNumbers();

        // then
        assertThat(actual.size()).isEqualTo(6);
    }
    @Test
    @DisplayName("getLottos는 오름차순으로 정렬된 List<Integer>를 반환한다.")
    void elementOfGertSortedLottoList(){
        // given
        LottoDTO lottoDTO = new LottoDTO(lotto);

        // when
        List<Integer> actual = lottoDTO.getLottoNumbers();
        List<Integer> expect = List.of(3,5,7,10,25,42);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}