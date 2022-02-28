package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;

    private final int number;

    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber from(final int number) {
        if (!numbers.containsKey(number)) {
            numbers.put(number, new LottoNumber(number));
        }
        return numbers.get(number);
    }

    private void validate(int number) {
        if (number < START_RANGE || number > END_RANGE) {
            throw new IllegalArgumentException(
                String.format("[ERROR] %d 부터 %d 사이의 숫자가 아닙니다.", START_RANGE, END_RANGE));
        }
    }

    public int getNumber() {
        return number;
    }
}
