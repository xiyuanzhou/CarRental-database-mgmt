package model;

public class Customer {
    private int id;
    private String customerName;
    private String address;
    private String phone;
    private String email;

    // Constructors
    public Customer() {
    }

    public Customer(int id, String customerName, String address, String phone, String email) {
    	this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public Customer(String customerName, String address, String phone, String email) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

