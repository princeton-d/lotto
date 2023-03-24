package org.example.domain.lotto;

import java.util.List;

public class LottoList {
    List<Lotto> lottoList;
    
    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    
    public static void create(List<List<Integer>> autoLottoList, List<Integer> handWriteLottoList) {
    
    }
}
