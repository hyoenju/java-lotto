package lotto.domain;

public class Number {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;

    private final int number;

    public Number(int number) {
        isValidate(number);
        this.number = number;
    }

    private void isValidate(int number) {
        if (number < START_RANGE || number > END_RANGE) {
            throw new IllegalArgumentException(
                String.format("[ERROR] %d 부터 %d 사이의 숫자가 아닙니다.", START_RANGE, END_RANGE));
        }
    }

    public int getNumber() {
        return number;
    }
}
