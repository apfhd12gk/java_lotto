package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_TO_GET_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_LOTTO_COUNT = "%d개를 구매 했습니다.%n";
    private static final String MESSAGE_FOR_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ", ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final Pattern LOTTO_PATTERN = Pattern.compile("(., )+.");
    private static final String ERROR_MESSAGE_FOR_INVALID_INPUT_FORMAT = "6개의 숫자를 ', ' 로 구분해서 입력해주세요";

    public static int scanInputMoney(){
        System.out.println(MESSAGE_TO_GET_INPUT_MONEY);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static void printException(Exception exception){
        System.out.println(ERROR_MESSAGE_PREFIX+exception.getMessage());
    }
    public static void printLottoCount(int count){
        System.out.printf(MESSAGE_FOR_LOTTO_COUNT,count);
    }

    public static List<Integer> scanWinningNumber() {
        System.out.print(System.lineSeparator());
        System.out.println(MESSAGE_FOR_WINNING_LOTTO_NUMBER);
        String userInput = SCANNER.nextLine();
        validateInputFormat(userInput);

        return Arrays.stream(userInput.split(SPLIT_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateInputFormat(String userInput){
        boolean matches =LOTTO_PATTERN.matcher(userInput).matches();

        if(!matches){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_INPUT_FORMAT);
        }
    }
    public static int scanBonusNumber(){
        System.out.println(MESSAGE_FOR_BONUS_LOTTO_NUMBER);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
