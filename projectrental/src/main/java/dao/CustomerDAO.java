package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import utils.DatabaseUtils;


public class CustomerDAO {
    	private static final String INSERT_USERS_SQL = "INSERT INTO Customer" + "  (customerName, address, phone, email) VALUES " +
            " (?, ?, ?, ?);";

        private static final String SELECT_USER_BY_ID = "select ID,customerName, address, phone, email from Customer where ID =?";
        private static final String SELECT_ALL_USERS = "select * from Customer";
        private static final String DELETE_USERS_SQL = "delete from Customer where ID = ?;";
        private static final String UPDATE_USERS_SQL = "update Customer set customerName = ?, address= ?, phone = ?, email = ? where ID = ?;";
        
    //shown all customer
    public List < Customer > selectAllUsers() {

        List < Customer > users = new ArrayList < > ();
        try (Connection connection = DatabaseUtils.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String customerName = rs.getString("customerName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                
                users.add(new Customer(id, customerName, address, phone, email));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return users;
    }
    
    public Customer getCustomerByID(int customerID) {
        String query = "SELECT * FROM Customer WHERE ID = ?";
        Customer customer = null;

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = extractCustomerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    // Helper method to extract customer details from a ResultSet
    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("ID"));
        customer.setCustomerName(resultSet.getString("customerName"));
        customer.setAddress(resultSet.getString("address"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setEmail(resultSet.getString("email"));
        return customer;
    }

    public void addCustomer(Customer customer) {
        String query = "INSERT INTO Customer (customerName, address, phone, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
}
