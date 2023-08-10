package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String MESSAGE_FOR_INVALID_NUMBER ="숫자만 입력해 주세요.";
    private static final String MESSAGE_TO_GET_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_LOTTO_COUNT = "%d개를 구매 했습니다.%n";
    private static final String MESSAGE_FOR_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_FOR_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ", ";
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";


    public static int scanInputMoney(){
        System.out.println(MESSAGE_TO_GET_INPUT_MONEY);
        try{
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException exception){
            throw new IllegalArgumentException(MESSAGE_FOR_INVALID_NUMBER);
        }

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
    public static void printLottos(Lottos lottos){
        lottos.getLottos()
                .forEach(InputView::printSingleLotto);
    }
    public static void printSingleLotto(Lotto lotto){
        String joinedLottoNumbers = lotto.getLottoNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SPLIT_DELIMITER));
        System.out.println("["+joinedLottoNumbers+"]");
    }
}
