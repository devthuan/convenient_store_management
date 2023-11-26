package model.Strategy;

public class VATCalculationStrategy implements InvoiceCalculationStrategy {
    private double vat_percentage;

    public VATCalculationStrategy(double vat_percentage) {
        this.vat_percentage = vat_percentage;
    }

    @Override
    public double calculateTotal(double sub_total) {
        return (sub_total + sub_total / vat_percentage);
    }

}
