package model;

import java.time.LocalDate;
import java.util.List;


public class Inventory extends BaseEntity {
    private static int product_id;
    private static String product_name;
    private static int quantity;
    private static String last_update;

    
    public Inventory(int product_id, String product_name , int quantity, LocalDate last_update2) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.last_update = last_update;
    }

    

    public static int getProduct_id() {
        return product_id;
    }


    public void setProduct_id(int new_product_id) {
        this.product_id = new_product_id;
    }

public static String getProduct_name() {
        return product_name;
    }


    public void setProduct_name(String new_product_name) {
        this.product_name = new_product_name;
    }


    public static int getQuantity() {
        return quantity;
    }

    public void setQuantity(int new_quantity) {
        Inventory.quantity = new_quantity;
    }

    public static String getLast_update() {
        return last_update;
    }

    public void set_last_update(String newLast_update) {
        Inventory.last_update = newLast_update;
    }

    

}
