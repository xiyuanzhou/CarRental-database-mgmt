package model;

public class Cars {
    private int carID;
    private String make;
    private String model;
    private int years;
    private String color;
    private int numberOfDoors;
    private String transmissionType;
    private String fuelType;
    private String gpsCheck;

    // Constructors
    public Cars() {
    }

    public Cars(int carID, String make, String model, int years, String color, int numberOfDoors, String transmissionType, String fuelType, String gpsCheck) {
        this.carID = carID;
    	this.make = make;
        this.model = model;
        this.years = years;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.gpsCheck = gpsCheck;
    }

    // Getters and Setters
    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getGpsCheck() {
        return gpsCheck;
    }

    public void setGpsCheck(String gpsCheck) {
        this.gpsCheck = gpsCheck;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", years=" + years +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", transmissionType='" + transmissionType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", gpsCheck='" + gpsCheck + '\'' +
                '}';
    }
}

