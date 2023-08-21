package lotto.view;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String MESSAGE_FOR_INVALID_NUMBER ="숫자만 입력해 주세요.";
    private static final String MESSAGE_TO_GET_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ", ";



    public static int scanInputMoney(){
        System.out.println(MESSAGE_TO_GET_INPUT_MONEY);
        try{
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException exception){
            throw new IllegalArgumentException(MESSAGE_FOR_INVALID_NUMBER);
        }

    }
    public static List<Integer> scanWinningNumber() {
        System.out.println(System.lineSeparator()+MESSAGE_FOR_WINNING_LOTTO_NUMBER);
        String userInput = SCANNER.nextLine();
        try{
            return Arrays.stream(userInput.split(SPLIT_DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }


    public static int scanBonusNumber(){
        System.out.println(MESSAGE_FOR_BONUS_LOTTO_NUMBER);
        try{
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException exception){
            throw new IllegalArgumentException(MESSAGE_FOR_INVALID_NUMBER);
        }
    }
}
