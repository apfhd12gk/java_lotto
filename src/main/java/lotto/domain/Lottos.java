package lotto.domain;

import java.util.*;


public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(LottoQuantity lottoQuantity, RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        this.lottos=generateLottos(lottoQuantity,randomLottoNumbersGenerate);
    }
    private void validNullOrEmpty(List<Lotto> lottos){
        if(Objects.isNull(lottos)||lottos.isEmpty()){
            throw new IllegalArgumentException("Lotto 목록이 비어 있습니다.");
        }
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
    private List<Lotto> generateLottos(LottoQuantity lottoQuantity,RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<lottoQuantity.getLottoQuantity();i++){
            lottos.add(new Lotto(generateLottoNumbers(randomLottoNumbersGenerate)));
        }
        return lottos;
    }
    private Set<Integer> generateLottoNumbers(RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        return new HashSet<>(randomLottoNumbersGenerate.generateLottoNumber());

    }
}
