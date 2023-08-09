package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentalAgreement {
    private int id;
    private String rentalStart;
    private String rentalEnd;
    private BigDecimal totalCost;
    private String status;
    private int carID;
    private int customerID;
    private int operatorID;
    
    private Customer customer;
    private Employee employee; 
    
    private String customerName;
    private String employeeName;  
    private String carMake;       
    private String carModel;      
    private String additionalRequests;  

    public RentalAgreement() {
    	
    }

    public RentalAgreement(int id, String rentalStart, String rentalEnd, BigDecimal totalCost,
                           String status, int carID, int customerID, int operatorID, String additionalRequests) {
        this.id = id;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
        this.totalCost = totalCost;
        this.status = status;
        this.carID = carID;
        this.customerID = customerID;
        this.operatorID = operatorID;
        this.additionalRequests = additionalRequests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRentalStart() {
        return rentalStart;
    }

    public void setRentalStart(String rentalStart) {
        this.rentalStart = rentalStart;
    }

    public String getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(String rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter and setter for the associated employee
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }
    
    public String getadditionalRequests() {
        return additionalRequests;
    }

    public void setadditionalRequests(String additionalRequests) {
        this.additionalRequests = additionalRequests;
    }
    
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getAdditionalRequests() {
        return additionalRequests;
    }

    public void setAdditionalRequests(String additionalRequests) {
        this.additionalRequests = additionalRequests;
    }
}

