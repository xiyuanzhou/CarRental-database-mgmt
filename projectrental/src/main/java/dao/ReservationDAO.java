package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RentalAgreement;
import model.Reservation;
import utils.DatabaseUtils;

public class ReservationDAO {
    private static final String DELETE_RESERVATION_SQL = "delete from Reservation where ID = ?;";

    public List<Reservation> getAllReservationsWithCustomers() {
        List<Reservation> reservationList = new ArrayList<>();
        String query = "SELECT R.ID AS ReservationID, "
        		+ "C.ID AS CustomerID, "
        		+ "C.customerName AS CustomerName, "
        		+ "R.PickupLocation, R.ReturnLocation, R.PickupDate, R.ReturnDate, R.CarTypePreference, R.AdditionalRequests "
        		+ "FROM Reservation R JOIN Customer C ON R.CustomerID = C.ID";

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(resultSet.getInt("ReservationID"));
                reservation.setCustomerID(resultSet.getInt("CustomerID"));
                reservation.setCustomerName(resultSet.getString("CustomerName"));
                reservation.setPickupLocation(resultSet.getString("PickupLocation"));
                reservation.setReturnLocation(resultSet.getString("ReturnLocation"));
                reservation.setPickupDate(resultSet.getString("PickupDate"));
                reservation.setReturnDate(resultSet.getString("ReturnDate"));
                reservation.setCarTypePreference(resultSet.getString("CarTypePreference"));
                reservation.setAdditionalRequests(resultSet.getString("AdditionalRequests"));

                reservationList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationList;
        
    }
    
    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO Reservation (CustomerID, PickupLocation, ReturnLocation, PickupDate, ReturnDate, CarTypePreference, AdditionalRequests) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	
        	preparedStatement.setInt(1, reservation.getCustomerID());
        	preparedStatement.setString(2, reservation.getPickupLocation());
        	preparedStatement.setString(3, reservation.getReturnLocation());
        	preparedStatement.setString(4, reservation.getPickupDate());
        	preparedStatement.setString(5, reservation.getReturnDate());
        	preparedStatement.setString(6, reservation.getCarTypePreference());
        	preparedStatement.setString(7, reservation.getAdditionalRequests());

        	preparedStatement.executeUpdate();
        	
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }
	
    //delete
    public boolean deleteReservation(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseUtils.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(DELETE_RESERVATION_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
}
