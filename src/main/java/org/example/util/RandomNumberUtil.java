//package org.example.util;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Random;
//
//public class RandomNumberUtil {
//    private static final int MAX_LOTTO_NUMBER = 45;
//    private static final int NUMBER_OF_LOTTO_NUMBER = 6;
//    private static final Random random = new Random();
//
//    public List<Integer> create() {
//        List<Integer> randomNumberLotto = new ArrayList<>();
//
//        CreateRandomLottoNumbers(randomNumberLotto);
//
//        return randomNumberLotto;
//    }
//
//    private void CreateRandomLottoNumbers(List<Integer> randomNumberLotto) {
//        int randomNumber = this.makeRandomNumber();
//
//        if (randomNumberLotto.size() == NUMBER_OF_LOTTO_NUMBER) {
//            return;
//        }
//        if (isDuplicateNumber(randomNumberLotto, randomNumber)) {
//            CreateRandomLottoNumbers(randomNumberLotto);
//        }
//        if (!isDuplicateNumber(randomNumberLotto, randomNumber)) {
//            randomNumberLotto.add(randomNumber);
//            Collections.sort(randomNumberLotto);
//        }
//
//        CreateRandomLottoNumbers(randomNumberLotto);
//    }
//
//    private int makeRandomNumber() {
//        int randomNumber = random.nextInt(MAX_LOTTO_NUMBER) + 1; // 1 ~ 45
//        return randomNumber;
//    }
//
//    private boolean isDuplicateNumber(List<Integer> list, int number) {
//        return list.contains(number);
//    }
//}
