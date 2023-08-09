package lotto.view;

import lotto.domain.Rank;
import lotto.domain.WinningCount;
import lotto.dto.LottoResultDTO;

import java.util.Map.Entry;


public class ResultView {
    private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    public static int NO_MATCH_RANK_INDEX_IN_REVERSED_RANK_VALUES = 0;
    public static void printResult(LottoResultDTO lottoResultDTO){
        printTitle();
        printWinningResult(lottoResultDTO);
        printProfitRatio(lottoResultDTO.getProfitRatio());
    }
    private static void printTitle(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    private static void printWinningResult(LottoResultDTO lottoResultDTO){
        for(Entry<Rank,WinningCount> rank  : lottoResultDTO.getRanks().entrySet()){
            System.out.println(printSingleLottoPrint(rank.getKey(),rank.getValue()));
        }
    }
    private static String printSingleLottoPrint(Rank rank, WinningCount winningCount){
        if(rank==Rank.SECOND){
            return String.format(BONUS_RANK_PRINT_FORMAT,rank.getSameNumberCount(),rank.getPrize(),winningCount.getCount());
        }
        return String.format(DEFAULT_RANK_PRINT_FORMAT,rank.getSameNumberCount(),rank.getPrize(),winningCount.getCount());
    }
    private static void printProfitRatio(double profitRatio){
        System.out.println("총 수익율은 "+profitRatio+"%입니다.");
    }
}
