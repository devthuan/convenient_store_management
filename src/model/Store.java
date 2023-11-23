package model;

public class Store extends BaseEntity {

    private String    name;
    private String    address;
    private String    phone;
    private String    store_manager;
    
    
    public Store() {

    }

    public Store(int id, String name, String address, String phone, String store_manager) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.store_manager = store_manager;
    }


    public Store(String phone, String store_manager) {
         this.phone = phone;
        this.store_manager = store_manager;
    }

    public Store(String name, String address, String phone, String store_manager) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.store_manager = store_manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStore_manager() {
        return store_manager;
    }

    public void setStore_manager(String store_manager) {
        this.store_manager = store_manager;
    }

}
