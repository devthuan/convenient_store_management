package model.Strategy;

public class DiscountCalculationStrategy implements InvoiceCalculationStrategy{

    private double discount_percentage;

    public DiscountCalculationStrategy(double discount_percentage){
        this.discount_percentage = discount_percentage;
    }

    @Override
    public double calculateTotal(double sub_total) {
        return sub_total * (1 - discount_percentage / 100);
    }
    
}
