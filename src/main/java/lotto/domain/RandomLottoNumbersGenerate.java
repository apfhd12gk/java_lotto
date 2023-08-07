package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumbersGenerate {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final  int LOTTO_SIZE = 6;

//    private static List<Integer> lottoNumber = new ArrayList<>();
    public List<Integer> generateLottoNumber(){
//        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER,LOTTO_NUMBER_INDEX);
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER,MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE);
    }

}
