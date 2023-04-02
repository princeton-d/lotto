package org.example.view;

import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoList;
import org.example.domain.result.Result;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OutputView {
    
    public void printLottosList(LottoList lottoList, List<Lotto> manualLottos, List<Lotto> autoLottos) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.size(), autoLottos.size());
        
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void printResult(Result result) {
        Map<BigDecimal, BigDecimal> rankList = result.getResult();
        
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + rankList.get(new BigDecimal(5000)) + "개");
        System.out.println("4개 일치 (50000원)- " + rankList.get(new BigDecimal(50000)) + "개");
        System.out.println("5개 일치 (1500000원)- " + rankList.get(new BigDecimal(1500000)) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + rankList.get(new BigDecimal(30000000)) + "개");
        System.out.println("6개 일치 (2000000000원)- " + rankList.get(new BigDecimal(2000000000)) + "개");
    }
    
    public void printRateOfReturn(BigDecimal rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
