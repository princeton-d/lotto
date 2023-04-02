package org.example.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);
    
    public int inputPrincipal() {
        System.out.println("구입 금액을 입력해 주세요.");
        return nextInteger();
    }
    
    public int inputManualLottoCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return nextInteger();
    }
    
    public void manualLottoNumbersGuid() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
    
    public List<Integer> inputManualLottoNumbers() {
        return extractInteger(nextString());
    }
    
    public List<Integer> inputLastWeekWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return extractInteger(nextString());
    }
    
    public int inputBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        
        return nextInteger();
    }
    
    private List<Integer> extractInteger(String line) {
        int ALLOW_LOTTO_COUNT = 6;
        int lottoNumberCount = line.split(DELIMITER).length;
    
        validateDuplicateLottoNumber(lottoNumberCount, line);
        validateLottoCount(ALLOW_LOTTO_COUNT, lottoNumberCount);
    
        try {
            return Arrays.stream(line.split(DELIMITER))
                .distinct() // 중복을 제거하고 새로운 스트림은 반환
                .limit(6)
                .map(Integer::parseInt) // (item -> Integer.parseInt(item))
                .collect(Collectors.toList()); // stream 의 데이터를 변형처리 하고 원하는 자료형으로 반환
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자와 쉼표(\",\"), 공백(\" \")으로 이루어지도록 번호를 입력해주세요.");
        }
    }
    
    private int nextInteger() {
        String inputValue = scanner.nextLine();
        validateNumberFormat(inputValue);
        return Integer.parseInt(inputValue);
    }
    
    private String nextString() {
        return removeSpace(scanner.nextLine());
    }
    
    private String removeSpace(String line) {
        return line.replaceAll(SPACE, BLANK);
    }
    
    private void validateNumberFormat(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력할 수 있습니다.");
        }
    }
    
    private void validateDuplicateLottoNumber(int prevCount, String line) {
        int deduplicateValue = new HashSet<>(Arrays.asList(line.split(DELIMITER))).size();
        if (prevCount != deduplicateValue) {
            throw new RuntimeException("중복된 수는 허용하지 않습니다.");
        }
    }
    
    private void validateLottoCount(int ALLOW_LOTTO_COUNT, int lottoNumberCount) {
        if (lottoNumberCount != ALLOW_LOTTO_COUNT) {
            throw new ArrayIndexOutOfBoundsException("로또 번호는 6개의 번호를 입력해야합니다.");
        }
    }
}