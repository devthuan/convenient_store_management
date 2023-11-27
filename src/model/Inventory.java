package model;

import java.time.LocalDate;
import java.util.List;

public class Inventory extends BaseEntity {
    private Product product;
    private LocalDate last_update;
    private LocalDate input_date;

    public Inventory() {

    }

    public Inventory(Product product, LocalDate input_date, LocalDate last_update) {
        this.product = product;
        this.input_date = input_date;
        this.last_update = last_update;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product new_product) {
        this.product = new_product;
    }

    public LocalDate getLastUpdate() {
        return last_update;
    }

    public LocalDate getInputDate() {
        return input_date;
    }

    public void setLastUpdate(LocalDate newLast_update) {
        this.last_update = newLast_update;
    }

}
