package org.example.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private List<Lotto> lottoList;
    
    private LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    
    public static LottoList create(List<List<Integer>> autoLottoList, List<List<Integer>> pickLottoList) {
        List<Lotto> lottoList = new ArrayList<>();
    
        for (List<Integer> lotto : pickLottoList) {
//            lottoList.add(new Lotto(lotto));
        }
        
        for (List<Integer> lotto : autoLottoList) {
//            lottoList.add(new Lotto(lotto));
        }
    
        return new LottoList(lottoList);
    }
}
