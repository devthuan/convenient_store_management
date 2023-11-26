package model.Strategy.payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public String getPaymentMethod() {
        return "Tiền mặt";
    }
}
