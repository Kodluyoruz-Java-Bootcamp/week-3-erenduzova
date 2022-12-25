package com.eren.emlakcepte.model;

public class Banner {

    private String realtyNo;
    private int count;
    private String phone1;
    private String phone2;
    private String address;

    public Banner(String realtyNo, int count, String phone1, String phone2, String address) {
        super();
        this.realtyNo = realtyNo;
        this.count = count;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
    }

    public String getRealtyNo() {
        return realtyNo;
    }

    public void setRealtyNo(String realtyNo) {
        this.realtyNo = realtyNo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "realtyNo='" + realtyNo + '\'' +
                ", count=" + count +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
