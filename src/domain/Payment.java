package lotto.domain;

public class Payment {

    public static final int LOTTO_PRICE = 1000;

    public final int paymentAmount;
    public final int numberOfPurchases;

    public Payment(final int paymentAmount) {
        isAvailableToPurchase(paymentAmount);
        this.paymentAmount = paymentAmount;
        numberOfPurchases = paymentAmount / LOTTO_PRICE;
    }

    private void isAvailableToPurchase(final int paymentAmount) {
        if (paymentAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구매할 수 있는 최소 금액보다 작습니다.");
        }
    }
}
