package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int SINGLE_LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER = String.format("%d개의 숫자를 골라주세요.", LOTTO_SIZE);
    private final Set<Integer> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(Set<Integer> lottoNumbers){
        validateSize(lottoNumbers);
        return new Lotto(lottoNumbers.stream()
                .collect(Collectors.toUnmodifiableSet()));
    }

    private static void validateSize(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_SIZE_OF_LOTTO_NUMBER);
        }
    }

    public int getSameNumberCount(Lotto otherLotto){
        List<Integer> intersection = new ArrayList<>(lottoNumbers);
        intersection.retainAll(otherLotto.lottoNumbers);

        return intersection.size();
    }
    public boolean containsLottoNumber(int lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }
    public List<Integer> getSortedLottoNumbers(){
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
