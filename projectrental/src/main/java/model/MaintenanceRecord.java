package model;

import java.math.BigDecimal;

public class MaintenanceRecord {
    private int id;
    private int carID;
    private String maintenanceDate;
    private String maintenanceType;
    private String maintenanceDescription;
    private BigDecimal maintenanceCost;

    public MaintenanceRecord() {
    }

    public MaintenanceRecord(int id, int carID, String maintenanceDate, String maintenanceType,
                             String maintenanceDescription, BigDecimal maintenanceCost) {
        this.id = id;
        this.carID = carID;
        this.maintenanceDate = maintenanceDate;
        this.maintenanceType = maintenanceType;
        this.maintenanceDescription = maintenanceDescription;
        this.maintenanceCost = maintenanceCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public BigDecimal getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(BigDecimal maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}

