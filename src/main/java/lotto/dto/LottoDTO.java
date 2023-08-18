package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoDTO {
    private final List<Integer> lottoNumbers;

    public LottoDTO(Lotto lotto){
        lottoNumbers = sortLottoNumbers(getLottoNumbersByLotto(lotto));
    }
    private List<Integer> getLottoNumbersByLotto(Lotto lotto){
        return new ArrayList<>(lotto.getLottoNumbers());
    }
    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers){
        List<Integer> copiedLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(copiedLottoNumbers);

        return copiedLottoNumbers;
    }

    public List<Integer> getLottoNumbers(){
        return List.copyOf(lottoNumbers);
    }

    @Override
    public String toString(){
        return "LottoDTO{" + "lottoNumbers=" + lottoNumbers +"}";
    }
}
