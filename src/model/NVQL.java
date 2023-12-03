package model;

public class NVQL extends Employee {

    public NVQL() {

    }

    public NVQL(String name, String gender, int age, String phone) {
        super(name, gender, age, phone);
    }

    @Override
    public double tinhLuong() {
        return 30000;
    }
}
