package lotto.domain;

import java.util.Objects;

public class InputMoney {
    private static final String ERROR_MESSAGE_FOR_INVALID_INPUT_MONEY = "금액은 1000원 이상, 1000원 단위로 입력해주세요";
    private static final int MINIMUM_MONEY = 1000;
    private static final int INPUT_MONEY_UNIT = 1000;
    private static final int REMAIN = 0;

    private final int money;
    public InputMoney(int money){
        validate(money);
        this.money = money;
    }
    private void validate(int money){
        if(isInvalidInputMoney(money)){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_INPUT_MONEY);
        }
    }
    private boolean isInvalidInputMoney(int money){
        return money < MINIMUM_MONEY || money % INPUT_MONEY_UNIT != REMAIN;
    }
    public int getMoney(){
        return money;
    }

    @Override
    public boolean equals(Object object){
        if(this==object){
            return true;
        }
        if(object == null || this.getClass() != object.getClass()){
            return false;
        }
        InputMoney that = (InputMoney) object;
        return money == that.money;
    }
    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return "money=" + money;
    }
}
