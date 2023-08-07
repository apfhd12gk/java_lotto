package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputMoneyTest {
    @Test
    @DisplayName("금액은 1000원 이상, 1000원 단위로 입력 해야한다.")
    void createInputMoneyTest(){
        int money=1000;
        InputMoney inputMoney = new InputMoney(money);
        assertThat(inputMoney.getMoney()).isEqualTo(money);
    }

    @ParameterizedTest(name="{0}원 입력 시, IAE 발생")
    @ValueSource(ints={999,-1,0,1111})
    void createInputMoneyWithInvalidMoney(int money){
        assertThatThrownBy(()->new InputMoney(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}