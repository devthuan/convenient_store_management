package model;

public class NVBH extends Employee {

    public NVBH() {

    }

    public NVBH(String name, String gender, int age, String phone, String position) {
        super(name, gender, age, phone, position);
    }

    @Override
    public double tinhLuong() {
        return 20000;
    }
}
