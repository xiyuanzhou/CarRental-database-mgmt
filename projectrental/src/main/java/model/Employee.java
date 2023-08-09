package model;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String ename;
    private String address;
    private String phone;
    private String email;
    private String roles;
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(int id, String ename, String address, String phone, String email, String roles, BigDecimal salary) {
        this.id = id;
        this.ename = ename;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roles = roles;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}

