package org.example;

import org.example.domain.lotto.*;
import org.example.domain.money.Money;
import org.example.domain.result.Result;
import org.example.util.CalculateUtil;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Money money;
    
    public void startApplication() {
        money = new Money(inputView.inputPrincipal());
        List<Lotto> manualLottos = buyManualLotto();
        List<Lotto> autoLottos = buyAutoLotto();
        LottoList lottoList = new LottoList(manualLottos, autoLottos);
        outputView.printLottosList(lottoList, manualLottos, autoLottos);
    
        Lotto winningLotto = new Lotto(new ManualLottoGenerator(inputView.inputLastWeekWinningNumbers()));
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusBallNumber());
        Result rankList = new Result(lottoList, winningLotto, bonusNumber);
        outputView.printResult(rankList);
    
        BigDecimal profit = CalculateUtil.calculateProfit(rankList);
        BigDecimal rateOfReturn = CalculateUtil.calculateRateOfReturn(money.getPrincipal(), profit);
        outputView.printRateOfReturn(rateOfReturn);
    }
    
    private List<Lotto> buyManualLotto() {
        int manualLottoCount = inputView.inputManualLottoCount();
        money.buyLotto(manualLottoCount);
        
        inputView.manualLottoNumbersGuid();
        
        return Stream.generate(() -> inputView.inputManualLottoNumbers())
            .limit(manualLottoCount)
            .map(lottoNumbers -> new Lotto(new ManualLottoGenerator(lottoNumbers)))
            .collect(Collectors.toList());
    }
    
    private List<Lotto> buyAutoLotto() {
        int autoLottoCount = money.countPurchasableLotto();
        
        money.buyLotto(autoLottoCount);
        
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        
        return Stream.generate(() -> new Lotto(autoLottoGenerator))
            .limit(autoLottoCount)
            .collect(Collectors.toList());
    }
}