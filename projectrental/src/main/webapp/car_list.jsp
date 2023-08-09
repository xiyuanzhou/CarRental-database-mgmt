<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Car List</title>
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
        h1 {
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
        <h1>Car List</h1>
        <p><a href="AddCarServlet">Add New Car</a></p>
        
        <table>
            <tr>
                <th>Car ID</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Color</th>
                <th>Number of Doors</th>
                <th>Transmission Type</th>
                <th>Fuel Type</th>
                <th>GPS Check</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${carList}" var="car">
                <tr>
                    <td>${car.carID}</td>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.years}</td>
                    <td>${car.color}</td>
                    <td>${car.numberOfDoors}</td>
                    <td>${car.transmissionType}</td>
                    <td>${car.fuelType}</td>
                    <td>${car.gpsCheck}</td>
                    <td>
                        <a href="ViewCarDetails?carID=${car.carID}">View Details</a>
                        <a href="EditCarServlet?carID=${car.carID}">Edit</a>
                        <a href="DeleteCarServlet?carID=${car.carID}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="back-link" href="home.jsp">Back to Home</a>
    </div>
</body>
</html>

