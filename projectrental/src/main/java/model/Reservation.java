package model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private int customerID;
    private String pickupLocation;
    private String returnLocation;
    private String pickupDate; 
    private String returnDate; 
    private String carTypePreference;
    private String additionalRequests;

    private String CustomerName;
    
    public Reservation() {
    }

    public Reservation(int id, int customerID, String pickupLocation, String returnLocation,
                       String pickupDate, String returnDate, String carTypePreference,
                       String additionalRequests) {
        this.id = id;
        this.customerID = customerID;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carTypePreference = carTypePreference;
        this.additionalRequests = additionalRequests;
    }
    
    public Reservation(int id, int customerID, String CustomerName, String pickupLocation, String returnLocation,
            String pickupDate, String returnDate, String carTypePreference,
            String additionalRequests) {
		this.id = id;
		this.customerID = customerID;
		this.CustomerName = CustomerName;
		this.pickupLocation = pickupLocation;
		this.returnLocation = returnLocation;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.carTypePreference = carTypePreference;
		this.additionalRequests = additionalRequests;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
    	return CustomerName;
    }
    
    public void setCustomerName(String CustomerName) {
    	this.CustomerName = CustomerName;
    }
    
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getCarTypePreference() {
        return carTypePreference;
    }

    public void setCarTypePreference(String carTypePreference) {
        this.carTypePreference = carTypePreference;
    }

    public String getAdditionalRequests() {
        return additionalRequests;
    }

    public void setAdditionalRequests(String additionalRequests) {
        this.additionalRequests = additionalRequests;
    }
}

