package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cars;
import utils.DatabaseUtils;

public class CarDAO {
	
    private static final String SELECT_USER_BY_ID = "select CarID, Make, Model, Years, Color, NumberOfDoors, TransmissionType, FuelType, GpsCheck from Car where CarID =?";
    private static final String SELECT_ALL_USERS = "select * from Car";
    private static final String DELETE_USERS_SQL = "delete from Car where CarID = ?;";
    private static final String UPDATE_USERS_SQL = "update Car set Make=?, Model=?, Years=?, Color=?, NumberOfDoors=?, TransmissionType=?, FuelType=?, GpsCheck=? where CarID = ?;";


    
    //shown all car
    public List < Cars > selectAllCars() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Cars > cars = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseUtils.getConnection();
        		
        	// Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
        	
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("CarID");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                int years = rs.getInt("Years");
                String color = rs.getString("Color");
                int numberofdoors = rs.getInt("NumberOfDoors");
                String transmissiontype = rs.getString("TransmissionType");
                String fueltype = rs.getString("FuelType");
                String gpscheck = rs.getString("GpsCheck");
                
                cars.add(new Cars(id, make, model, years, color, numberofdoors, transmissiontype, fueltype, gpscheck));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return cars;
    }
    
    //update customer
    public void updateCarDetails(int carID, String updatedMake, String updatedModel, int updatedYears, String updatedColor, int updatedNumofdoor, String updatedtransmissionType, String updatedfuelType, String updatedgpsCheck) throws SQLException {

        try (Connection connection = DatabaseUtils.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            
            statement.setString(1, updatedMake);
            statement.setString(2, updatedModel);
            statement.setInt(3, updatedYears);
            statement.setString(4, updatedColor);
            statement.setInt(5, updatedNumofdoor);
            statement.setString(6, updatedtransmissionType);
            statement.setString(7, updatedfuelType);
            statement.setString(8, updatedgpsCheck);
            statement.setInt(9, carID);

            statement.executeUpdate();

        }
    }
    
    
    //delete
    public boolean deleteCar(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

	public Cars getCarID(int carID) {
        Cars car = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseUtils.getConnection();
        		
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, carID);
            System.out.println(preparedStatement);
            
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                int years = rs.getInt("Years");
                String color = rs.getString("Color");
                int numberofdoors = rs.getInt("NumberOfDoors");
                String transmissiontype = rs.getString("TransmissionType");
                String fueltype = rs.getString("FuelType");
                String gpscheck = rs.getString("GpsCheck");
                
                car = new Cars(carID, make, model, years, color, numberofdoors, transmissiontype, fueltype, gpscheck);
            }
        } catch (SQLException e) {
        	
        	e.printStackTrace();
        }
        return car;
	}

	public void addCar(Cars car) {


        String query = "INSERT INTO Car (Make, Model, Years, Color, NumberOfDoors, TransmissionType, FuelType, GpsCheck) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYears());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setInt(5, car.getNumberOfDoors());
            preparedStatement.setString(6, car.getTransmissionType());
            preparedStatement.setString(7, car.getFuelType());
            preparedStatement.setString(8, car.getGpsCheck());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
