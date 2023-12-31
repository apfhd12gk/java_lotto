package lotto.dto;

import lotto.domain.LottoQuantity;
import lotto.domain.Rank;
import lotto.domain.WinningCount;

import java.util.EnumMap;
import java.util.Map;

public class LottoResultDTO {
    public static final double ROUND_UNIT = 100.0;
    public static final double SINGLE_LOTTO_PRICE = 1000.0;
    private final Map<Rank,WinningCount> lottoWinningResult;
    private final double profitRatio;
    private LottoResultDTO(Map<Rank,WinningCount> lottoWinningResult, double profitRatio ){
        this.lottoWinningResult = lottoWinningResult;
        this.profitRatio = profitRatio;
    }
    public static LottoResultDTO from(Map<Rank,WinningCount> lottoWinningResult, LottoQuantity lottoQuantity){
        Long totalPrize = lottoWinningResult.entrySet()
                .stream()
                .map((entrySet)->entrySet.getKey().getPrize() * entrySet.getValue().getCount())
                .reduce(0L,Long::sum);
        return new LottoResultDTO(lottoWinningResult,getProfitRatio(totalPrize,lottoQuantity));
    }
    private static double getProfitRatio(long totalPrize, LottoQuantity lottoQuantity){
        double purchaseMoney = (lottoQuantity.getLottoQuantity() * SINGLE_LOTTO_PRICE);
        return  roundToSecondDigit(totalPrize/purchaseMoney);
    }
    private static double roundToSecondDigit(double number){
        return Math.round(number * ROUND_UNIT)/ROUND_UNIT;
    }
    public WinningCount getWinningCountByRank(Rank rank){
        return lottoWinningResult.get(rank);
    }
    public Map<Rank, WinningCount> getRanks(){
        Map<Rank,WinningCount> ranks = new EnumMap<>(this.lottoWinningResult);
        ranks.remove(Rank.NO_MATCH);
        return ranks;
    }
    public double getProfitRatio(){
        return profitRatio;
    }
    @Override
    public String toString() {
        return "LottoResultDto{" +
                "lottoWinningResult=" + lottoWinningResult +
                ", profitRatio=" + profitRatio +
                '}';
    }
}
