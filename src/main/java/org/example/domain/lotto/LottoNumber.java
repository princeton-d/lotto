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

    public int getNumber() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
