package model.Strategy.payment;

public class MomoPayment implements PaymentStrategy {
    @Override
    public String getPaymentMethod() {
        return "Chuyển khoản Momo";
    }
}
