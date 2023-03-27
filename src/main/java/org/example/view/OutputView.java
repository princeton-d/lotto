package org.example.view;

import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoList;

public class OutputView {
    
    public void printLottoList(LottoList lottoList) {
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
