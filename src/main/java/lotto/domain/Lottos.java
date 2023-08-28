package lotto.domain;

import java.util.*;


public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos){
        this.lottos=lottos;
    }
    public static Lottos of(LottoQuantity lottoQuantity, RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        return new Lottos(generateLottos(lottoQuantity, randomLottoNumbersGenerate));
    }
    public static Lottos from(List<Lotto> lottos){
        return new Lottos(lottos);
    }

    private void validNullOrEmpty(List<Lotto> lottos){
        if(Objects.isNull(lottos)||lottos.isEmpty()){
            throw new IllegalArgumentException("Lotto 목록이 비어 있습니다.");
        }
    }
    public List<Lotto> getLottos(){
        return lottos;
    }
    private static List<Lotto> generateLottos(LottoQuantity lottoQuantity,RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<lottoQuantity.getLottoQuantity();i++){
            lottos.add(Lotto.from(generateLottoNumbers(randomLottoNumbersGenerate)));
        }
        return lottos;
    }
    public static Lottos concat(Lottos lottos1, Lottos lottos2) {
        List<Lotto> newLottoValues = new ArrayList<>(lottos1.lottos);
        newLottoValues.addAll(lottos2.lottos);

        return new Lottos(newLottoValues);
    }

    private static Set<Integer> generateLottoNumbers(RandomLottoNumbersGenerate randomLottoNumbersGenerate){
        return new HashSet<>(randomLottoNumbersGenerate.generateLottoNumber());
    }

}
