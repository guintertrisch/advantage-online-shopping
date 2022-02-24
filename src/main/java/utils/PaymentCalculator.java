package utils;

public class PaymentCalculator {

    public static String getAmountPayment(int quantity, String amount) {
        int valueTotal = Integer.parseInt(amount) * quantity;

        return String.valueOf(valueTotal);
    }
}