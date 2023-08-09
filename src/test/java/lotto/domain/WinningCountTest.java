package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WinningCountTest {
    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void createWinningCountTest(int input){
        WinningCount winningCount= new WinningCount(input);

        assertThat(winningCount).isNotNull();
    }
    @ParameterizedTest
    @ValueSource(ints = {-3,-5})
    void createWinningCountWithNegative(int input){
        assertThatThrownBy(()->new WinningCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("당첨 횟수는 0이상 이어야 합니다.");
    }
}