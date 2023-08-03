package lotto.domain;

import java.util.List;


public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER ="[ERROR] %d개의 숫자를 골라 주세요.";
    private static final String ERROR_MESSAGE_FOR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 숫자는 중복될 수 없습니다.";
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER);
        }
    }
    private void validateDuplicate(List<Integer> lottoNumbers){
        if(isDuplicate(lottoNumbers)){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_DUPLICATE_LOTTO_NUMBER);
        }
    }

    private boolean isDuplicate(List<Integer> lottoNumbers){
        return lottoNumbers.size() != lottoNumbers.stream()
                .distinct()
                .count();
    }
    public int getSameNumberCount(Lotto anotherLotto){
        return (int) lottoNumbers.stream()
                .filter(anotherLotto::containsLottoNumber).count();
    }
    private boolean containsLottoNumber(int lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }
}
