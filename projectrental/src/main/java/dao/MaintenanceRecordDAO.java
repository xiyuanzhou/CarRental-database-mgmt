package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MaintenanceRecord;
import utils.DatabaseUtils;

public class MaintenanceRecordDAO {

    public List<MaintenanceRecord> getMaintenanceRecordsByCarID(int carID) {
        String query = "SELECT * FROM MaintenanceRecord WHERE CarID = ?";
        List<MaintenanceRecord> maintenanceRecords = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getConnection();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, carID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MaintenanceRecord maintenanceRecord = extractMaintenanceRecordFromResultSet(resultSet);
                maintenanceRecords.add(maintenanceRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maintenanceRecords;
    }

    // Helper method to extract maintenance record details from a ResultSet
    private MaintenanceRecord extractMaintenanceRecordFromResultSet(ResultSet resultSet) throws SQLException {
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord();
        maintenanceRecord.setId(resultSet.getInt("ID"));
        maintenanceRecord.setCarID(resultSet.getInt("CarID"));
        maintenanceRecord.setMaintenanceDate(resultSet.getString("MaintenanceDate"));
        maintenanceRecord.setMaintenanceType(resultSet.getString("MaintenanceType"));
        maintenanceRecord.setMaintenanceDescription(resultSet.getString("MaintenanceDescription"));
        maintenanceRecord.setMaintenanceCost(resultSet.getBigDecimal("MaintenanceCost"));
        return maintenanceRecord;
    }

}
