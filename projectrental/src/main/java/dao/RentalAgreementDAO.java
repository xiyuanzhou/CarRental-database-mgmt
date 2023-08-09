package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.RentalAgreement;
import utils.DatabaseUtils;

public class RentalAgreementDAO {

    private static final String SELECT_ALL_USERS = "select * from RentalAgreement";

    public List<RentalAgreement> getRentalAgreementsByCarID(int carID) {
        String query = "SELECT * FROM RentalAgreement WHERE CarID = ?";
        List<RentalAgreement> rentalAgreements = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, carID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RentalAgreement rentalAgreement = extractRentalAgreementFromResultSet(resultSet);
                rentalAgreements.add(rentalAgreement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentalAgreements;
    }

    // Helper method to extract rental agreement details from a ResultSet
    private RentalAgreement extractRentalAgreementFromResultSet(ResultSet resultSet) throws SQLException {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setId(resultSet.getInt("ID"));
        rentalAgreement.setRentalStart(resultSet.getString("RentalStart"));
        rentalAgreement.setRentalEnd(resultSet.getString("RentalEnd"));
        rentalAgreement.setTotalCost(resultSet.getBigDecimal("TotalCost"));
        rentalAgreement.setStatus(resultSet.getString("Status"));

        return rentalAgreement;
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        String query = "INSERT INTO RentalAgreement (RentalStart, RentalEnd, TotalCost, Status, CarID, CustomerID, OperatorID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        	
	            preparedStatement.setString(1, rentalAgreement.getRentalStart());
	            preparedStatement.setString(2, rentalAgreement.getRentalEnd());
	            preparedStatement.setBigDecimal(3, rentalAgreement.getTotalCost());
	            preparedStatement.setString(4, rentalAgreement.getStatus());
	            preparedStatement.setInt(5, rentalAgreement.getCarID());
	            preparedStatement.setInt(6, rentalAgreement.getCustomerID());
	            preparedStatement.setInt(7, rentalAgreement.getOperatorID());

               preparedStatement.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }
    }


	public List<RentalAgreement> getAllrentalAgreements() {
        List<RentalAgreement> rentalAgreements = new ArrayList<>();

        String query = "SELECT ra.ID, ra.RentalStart, ra.RentalEnd, ra.TotalCost, ra.Status, " +
                "c.customerName AS customerName, e.ename AS employeeName, " +
                "car.Make AS carMake, car.Model AS carModel, ra.AdditionalRequests " +
                "FROM RentalAgreement ra " +
                "INNER JOIN Customer c ON ra.CustomerID = c.ID " +
                "INNER JOIN Employee e ON ra.OperatorID = e.ID " +
                "INNER JOIN Car car ON ra.CarID = car.CarID";

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
        	
            while (resultSet.next()) {
                RentalAgreement rentalAgreement = new RentalAgreement();
                rentalAgreement.setId(resultSet.getInt("ID"));
                rentalAgreement.setRentalStart(resultSet.getString("RentalStart"));
                rentalAgreement.setRentalEnd(resultSet.getString("RentalEnd"));
                rentalAgreement.setTotalCost(resultSet.getBigDecimal("TotalCost"));
                rentalAgreement.setStatus(resultSet.getString("Status"));
                rentalAgreement.setCustomerName(resultSet.getString("customerName"));
                rentalAgreement.setEmployeeName(resultSet.getString("employeeName"));
                rentalAgreement.setCarMake(resultSet.getString("carMake"));
                rentalAgreement.setCarModel(resultSet.getString("carModel"));
                rentalAgreement.setAdditionalRequests(resultSet.getString("AdditionalRequests"));

                rentalAgreements.add(rentalAgreement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentalAgreements;
	}
	
	public List<RentalAgreement> getAllrentalAgreements1() {

		
        List < RentalAgreement > ra = new ArrayList < > ();
        try (Connection connection = DatabaseUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String RentalStart = rs.getString("RentalStart");
                String RentalEnd = rs.getString("RentalEnd");
                BigDecimal TotalCost = rs.getBigDecimal("TotalCost");
                String Status = rs.getString("Status");
                int CarID = rs.getInt("CarID");
                int CustomerID = rs.getInt("CustomerID");
                int OperatorID = rs.getInt("OperatorID");
                String AdditionalRequests = rs.getString("AdditionalRequests");

                
                ra.add(new RentalAgreement(id, RentalStart, RentalEnd, TotalCost, Status, CarID, CustomerID, OperatorID, AdditionalRequests));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return ra;
	}
	
}
