package lotto   ;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("WinningLotto를 Lotto 와 bonusnumber를 받아서 인스턴스 생성")
    void createWinningLottoTest(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto,bonusNumber);

        assertThat(winningLotto).isNotNull();
    }
    @Test
    @DisplayName("생성자에 전달된 bonusNmber가 lotto에 포함될 경우 예외를 발생")
    void createWinningLottoDuplicateBonusNumber(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 4;

        assertThatThrownBy(()->new WinningLotto(lotto,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
