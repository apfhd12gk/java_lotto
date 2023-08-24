package lotto.domain;

import java.util.Collections;
import java.util.Set;

public class Lotto {
    public static final int SINGLE_LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER ="[ERROR] %d개의 숫자를 골라 주세요.";
    private static final String ERROR_MESSAGE_FOR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 숫자는 중복될 수 없습니다.";
    private final Set<Integer> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    private void validateSize(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER);
        }
    }

    public int getSameNumberCount(Lotto anotherLotto){
        return (int) lottoNumbers.stream()
                .filter(anotherLotto::containsLottoNumber).count();
    }
    public boolean containsLottoNumber(int lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }
    public Set<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
