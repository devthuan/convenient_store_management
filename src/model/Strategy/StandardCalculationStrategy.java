package model.Strategy;

public class StandardCalculationStrategy implements InvoiceCalculationStrategy {

    @Override
    public double calculateTotal(double sub_total) {
        return sub_total;
    }
    
}
