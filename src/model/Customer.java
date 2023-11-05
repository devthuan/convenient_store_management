package model;

import java.util.List;

public class Customer extends BaseEntity {
    private String name;
    private String address;
    private String phone;
    private List<Customer> customers;

    public Customer() {

    }

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Customer(int id, String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public int getId() {
        return super.getId();
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

    public static void exportCustomer(Customer customer) {
        System.out.println("------------------------------------------------");
        System.out.println("Mã khách hàng: " + customer.getId());
        System.out.println("Họ và tên khách hàng : " + customer.getName());
        System.out.println("Địa chỉ khách hàng : " + customer.getAddress());
        System.out.println("Số điện thoại khách hàng :" + customer.getPhone());
        System.out.println("------------------------------------------------");
    }

    public static void exportAllEmployee(List<Customer> customers) {
        if (customers != null) {
            System.out.println("===================================");
            System.out.println("         DANH SÁCH KHÁCH HÀNG       ");
            System.out.println("===================================");
            System.out.println("-------+--------------------- +----------------------------+-------------------");
            System.out.println("|  ID  |       Họ và tên      |           Địa chỉ          |   Số điện thoại  |");
            System.out.println("-------+----------------------+----------------------------+-------------------");
            for (Customer customerInformation : customers) {
                System.out.println(
                        String.format("| %4s | %19s | %27s | %11s |",
                                customerInformation.getId(),
                                customerInformation.getName(),
                                customerInformation.getAddress(),
                                customerInformation.getPhone()));
            }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Không có thông tin nào về khách hàng");
        }
    }
}
