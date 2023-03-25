package org.example;

import org.example.domain.lotto.AutoLottoGenerator;
import org.example.domain.lotto.Lotto;
import org.example.domain.lotto.LottoGenerator;
import org.example.domain.lotto.ManualLottoGenerator;
import org.example.domain.money.Money;
import org.example.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private final InputView inputView = new InputView();
    private Money money;

    public void startApplication() {
        money = new Money(inputView.inputMoney());

        List<Lotto> manualLottos = buyManualLotto();
        List<Lotto> autoLottos = buyAutoLotto();
        // TODO Lotto 합치고 이후 구현

        manualLottos.addAll(autoLottos);
        manualLottos.forEach(System.out::println);
    }

    public List<Lotto> buyManualLotto() {
        int manualLottoNum = inputView.inputManualLottoNum();
//        List<Lotto> list = new ArrayList<>();
//        for (int i = 0; i < manualLottoNum; i++) {
//            List<Integer> integers = inputView.inputManualLottoNumbers();
//            Lotto lotto = new Lotto(new ManualLottoGenerator(integers));
//            list.add(lotto);
//        }

        money.buyLotto(manualLottoNum);

        return Stream.generate(inputView::inputManualLottoNumbers)
                .limit(manualLottoNum)
                .map(lottoNumbers -> new Lotto(new ManualLottoGenerator(lottoNumbers)))
                .collect(Collectors.toList());
    }

    public List<Lotto> buyAutoLotto() {
        int autoLottoNum = money.countPurchasableLotto();

        money.buyLotto(autoLottoNum);

        LottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        return Stream.generate(() -> new Lotto(autoLottoGenerator))
                .limit(autoLottoNum)
                .collect(Collectors.toList());
    }
}