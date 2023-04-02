package org.example.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoList {
    private List<Lotto> lottoList;
    
    public LottoList(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> lottoList = Stream.concat(manualLottos.stream(), autoLottos.stream())
            .collect(Collectors.toList());
        
        this.lottoList = lottoList;
    }
    
    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
