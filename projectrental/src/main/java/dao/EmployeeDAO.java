package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cars;
import model.Employee;
import utils.DatabaseUtils;

public class EmployeeDAO {
	
	
    private static final String SELECT_ALL_EMPLOYEE = "select * from Employee";
    private static final String DELETE_USERS_SQL = "delete from Employee where ID = ?;";
    private static final String UPDATE_USERS_SQL = "update Employee set ename=?, address=?, phone=?, email=?, roles=?, salary=? where ID = ?;";

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        
        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("ID"));
                employee.setEname(resultSet.getString("ename"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setEmail(resultSet.getString("email"));
                employee.setRoles(resultSet.getString("roles"));
                employee.setSalary(resultSet.getBigDecimal("salary"));
                
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employeeList;
    }
    
    //delete
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DatabaseUtils.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

	public Employee getEmployeeID(int employeeID) {

        String query = "SELECT * FROM Employee WHERE ID = ?";
        Employee employee = null;

        try (Connection connection = DatabaseUtils.getConnection();
        		
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
        	
            preparedStatement.setInt(1, employeeID);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while (rs.next()) {
                String ename = rs.getString("ename");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String roles = rs.getString("roles");
                BigDecimal salary = rs.getBigDecimal("salary");
                
                employee = new Employee(employeeID, ename, address, phone, email, roles, salary);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employee;


	}

	public void updateEmployeeDetails(int employeeID, String ename, String address, String phone, String email,
			String roles, BigDecimal salary) throws SQLException {
		
        try (Connection connection = DatabaseUtils.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            
            statement.setString(1, ename);
            statement.setString(2, address);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, roles);
            statement.setBigDecimal(6, salary);
            statement.setInt(7, employeeID);

            statement.executeUpdate();

        }
		
	}
	
    public Employee getEmployeeByID(int employeeID) {
        String query = "SELECT * FROM Employee WHERE ID = ?";
        Employee employee = null;

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employee = extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    // Helper method to extract employee details from a ResultSet
    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setEname(resultSet.getString("ename"));
        employee.setAddress(resultSet.getString("address"));
        employee.setPhone(resultSet.getString("phone"));
        employee.setEmail(resultSet.getString("email"));
        employee.setRoles(resultSet.getString("roles"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        return employee;
    }

    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employee (ename, address, phone, email, roles, salary) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getEname());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getPhone());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getRoles());
            preparedStatement.setBigDecimal(6, employee.getSalary());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

