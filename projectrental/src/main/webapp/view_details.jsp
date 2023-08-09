<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Car Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1, h2 {
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f5f5f5;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
        .back-link {
            display: block;
            margin-top: 20px;
            color: #007bff;
        }
        .back-link:hover {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Car Details</h1>
        <p><strong>Car ID:</strong> ${car.carID}</p>
        <p><strong>Make:</strong> ${car.make}</p>
        <p><strong>Model:</strong> ${car.model}</p>

        <h2>Rental Agreements</h2>
        <table>
            <tr>
                <th>Rental ID</th>
                <th>Rental Start</th>
                <th>Rental End</th>
                <th>Total Cost</th>
                <th>Status</th>
            </tr>
            <c:forEach items="${rentalAgreements}" var="rental">
                <tr>
                    <td>${rental.id}</td>
                    <td>${rental.rentalStart}</td>
                    <td>${rental.rentalEnd}</td>
                    <td>${rental.totalCost}</td>
                    <td>${rental.status}</td>
                </tr>
            </c:forEach>
        </table>

        <!-- Maintenance Records -->
        <h2>Maintenance Records</h2>
        <table>
            <tr>
                <th>Maintenance ID</th>
                <th>Maintenance Date</th>
                <th>Maintenance Type</th>
                <th>Maintenance Description</th>
                <th>Maintenance Cost</th>
                <!-- Add other columns as needed -->
            </tr>
            <c:forEach items="${maintenanceRecords}" var="maintenance">
                <tr>
                    <td>${maintenance.id}</td>
                    <td>${maintenance.maintenanceDate}</td>
                    <td>${maintenance.maintenanceType}</td>
                    <td>${maintenance.maintenanceDescription}</td>
                    <td>${maintenance.maintenanceCost}</td>
                    <!-- Add other columns as needed -->
                </tr>
            </c:forEach>
        </table>
        
        <!-- Go Back button -->
        <a class="back-link" href="CarServlet">Go Back to Car List</a>
    </div>
</body>
</html>
