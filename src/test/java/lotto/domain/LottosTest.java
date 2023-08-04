package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.NullAndEmptySource;
//import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    private List<Lotto> lottos = new ArrayList<>();
    @BeforeEach
    void setupLottos(){
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,3,4,5,6,7));
        Lotto lotto3 = new Lotto(List.of(3,4,5,6,7,9));

        lottos = List.of(lotto1, lotto2, lotto3);
    }

    @Test
    @DisplayName("List<Lotto> 를 전달받아 Lottos 생성")
    void createLottos(){
        Lottos validLottos = new Lottos(lottos);

        assertThat(validLottos).isNotNull();
    }

//    @ParameterizedTest(name="Lottos 생성자에 null값이 전달된 경우")
//    @NullSource
//    void createLottosWithNullAndEmptyShouldFail(List<Lotto> lottos){
//        assertThatThrownBy(()->new Lottos(lottos))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

}