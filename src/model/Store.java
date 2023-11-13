package model;

import java.util.List;

public class Store extends BaseEntity {

    private int        store_id;
    private String     store_name;
    private String     store_address;
    private String     store_phone;
    private String   store_manager;

    public Store() {

    }

    public Store(int store_id,String store_name, String store_address, String store_phone, String store_manager) {
        this.store_name = store_name;
        this.store_address = store_address;
        this.store_phone = store_phone;
        this.store_manager = store_manager;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String name) {
        this.store_name = store_name;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public void setStore_phone(String store_phone) {
        this.store_phone = store_phone;
    }

    public String getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(String store_manager) {
        this.store_manager = store_manager;
    }

}
