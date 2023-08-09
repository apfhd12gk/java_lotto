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

    @ParameterizedTest(name="1000원보다 작은 금액 전달 시 IAE 발생 - {0}")
    @ValueSource(ints = {-1000,0,1,999})
    void createInputMoneySmallerThan1000(int money){
        assertThatThrownBy(()->new InputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1000원 보다 작은 금액을 입력할 수 없습니다.");
    }
    @ParameterizedTest(name="1000원으로 나누어 떨어지지 않는 금액 전달 시 IAE 발생 - {0}")
    @ValueSource(ints = {1500,2100,3333})
    void createInputMoneyWithNotMultipleOf1000(int money){
        assertThatThrownBy(()->new InputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1000원으로 나누어 떨어지지 않는 금액을 입력할 수 없습니다.");
    }
}