package model.Strategy.payment;

public class CardPayment implements PaymentStrategy {
    @Override
    public String getPaymentMethod() {
        return "The tin dung";
    }
}
