package org.example;

import org.example.domain.lotto.*;
import org.example.domain.money.Money;
import org.example.domain.result.Result;
import org.example.domain.winning_number.BonusBallNumber;
import org.example.domain.winning_number.WinningNumbers;
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
        outputView.printLottoList(lottoList, manualLottos, autoLottos);
        
        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputLastWeekWinningNumbers());
        BonusBallNumber bonusBall = new BonusBallNumber(inputView.inputBonusBallNumber());
        Result rankList = new Result(lottoList, winningNumbers, bonusBall);
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
        int autoLottoNum = money.countPurchasableLotto();
        
        money.buyLotto(autoLottoNum);
        
        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        
        return Stream.generate(() -> new Lotto(autoLottoGenerator))
            .limit(autoLottoNum)
            .collect(Collectors.toList());
    }
}