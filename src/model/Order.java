package model;

import java.util.List;

public class Order extends BaseEntity {
    private int order_id;
    private Product product;
    private int quantity;
    private Customer customer;
    private List<Product> products;
    private Transaction transaction;

}
