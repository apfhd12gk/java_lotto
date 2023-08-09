package lotto.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;
    public static List<Integer> LOTTO_NUMBERS;
    static {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i = LOTTO_NUMBER_START; i <= LOTTO_NUMBER_END; i++){
            lottoNumbers.add(i);
        }
        LOTTO_NUMBERS = Collections.unmodifiableList(lottoNumbers);
    }
    private LottoNumbers(){

    }

}
