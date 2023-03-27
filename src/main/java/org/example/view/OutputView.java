package org.example.view;

import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoList;

import java.util.List;

public class OutputView {
    
    public void printLottoList(LottoList lottoList, List<Lotto> manualLottos, List<Lotto> autoLottos) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottos.size(), autoLottos.size());

        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
