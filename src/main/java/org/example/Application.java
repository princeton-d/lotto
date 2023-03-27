package org.example;

import org.example.domain.lotto.*;
import org.example.domain.money.Money;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Money money;
    
    public void startApplication() {
        money = new Money(inputView.inputMoney());
        List<Lotto> manualLottos = buyManualLotto();
        List<Lotto> autoLottos = buyAutoLotto();
        LottoList lottoList = new LottoList(manualLottos, autoLottos);
        outputView.printLottoList(lottoList, manualLottos, autoLottos);


    }
    
    private List<Lotto> buyManualLotto() {
        int manualLottoNum = inputView.inputManualLottoNum();
        money.buyLotto(manualLottoNum);
    
        return Stream.generate(() -> inputView.inputManualLottoNumbers())
            .limit(manualLottoNum)
            .map(lottoNumbers -> new Lotto(new ManualLottoGenerator(lottoNumbers)))
            .collect(Collectors.toList());
    }
    
    private List<Lotto> buyAutoLotto() {
        int autoLottoNum = money.countPurchasableLotto();
        
        money.buyLotto(autoLottoNum);
    
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    
        return Stream.generate(() -> new Lotto(autoLottoGenerator))
            .limit(autoLottoNum)
            .collect(Collectors.toList());
    }
}