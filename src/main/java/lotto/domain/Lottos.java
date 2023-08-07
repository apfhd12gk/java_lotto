package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos=lottos;
    }
    private void validNullOrEmpty(List<Lotto> lottos){
        if(Objects.isNull(lottos)||lottos.isEmpty()){
            throw new IllegalArgumentException("Lotto 목록이 비어 있습니다.");
        }
    }
    public List<Lotto> getLottos(){
        return lottos;
    }

}
