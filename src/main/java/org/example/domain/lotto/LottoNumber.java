package org.example.domain.lotto;

public class LottoNumber {
    public static final int NIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private final int value;
    
    public LottoNumber(int value) {
        if (value < NIN_VALUE || value > MAX_VALUE) {
            throw new IllegalStateException();
        }
        
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "" + value;
    }
}
