package model;

import java.util.List;

import model.Product;

public class Inventory extends BaseEntity {
    private int inventory_id;
    private Product product;
    private int quantity;
    private String last_update;

    public Inventory() {

    }

    public Inventory(int inventory_id, Product product, int quantity, String last_update) {
        this.inventory_id = inventory_id;
        this.product = product;
        this.quantity = quantity;
        this.last_update = last_update;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int new_inventory_id) {
        this.inventory_id = new_inventory_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product newProduct) {
        this.product = newProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int new_quantity) {
        this.quantity = new_quantity;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_updateame(String newLast_update) {
        this.last_update = newLast_update;
    }

    public static void exportInventory(List<Product> products) {
        if (products != null){

            System.out.println("===================================");
            System.out.println("         DANH SACH SAN PHAM      ");
            System.out.println("===================================");
            System.out.println("-------+---------------------+-----");
            System.out.println("|  ID  |     TEN       |  GIA  |");
            System.out.println("-------+---------------------+-----");
            for (Product product : products) {

                System.out.println(
                        String.format("| %4s | %19s | %11s |",
                                product.getId(),
                                product.getName(),
                                product.getPrice()))
            }
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println();

        } else {
            System.out.println("Không có dữ liệu nào!");
        }

        }
}
