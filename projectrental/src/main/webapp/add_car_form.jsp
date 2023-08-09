<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Add New Rental Car</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<div class="container">
    <h2>Add New Car</h2>
    <form action="AddCarServlet" method="post">
        <div class="form-group">
            <label for="make">Make:</label>
            <input type="text" id="make" name="make" required>
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" id="model" name="model" required>
        </div>
        <div class="form-group">
            <label for="years">Years:</label>
            <input type="number" id="years" name="years" required>
        </div>
        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" id="color" name="color" required>
        </div>
        <div class="form-group">
            <label for="numberOfDoors">Number of Doors:</label>
            <input type="number" id="numberOfDoors" name="numberOfDoors" required>
        </div>
        <div class="form-group">
            <label for="transmissionType">Transmission Type:</label>
            <input type="text" id="transmissionType" name="transmissionType" required>
        </div>
        <div class="form-group">
            <label for="fuelType">Fuel Type:</label>
            <input type="text" id="fuelType" name="fuelType" required>
        </div>
        <div class="form-group">
            <label for="gpsCheck">GPS Check:</label>
            <input type="text" id="gpsCheck" name="gpsCheck" required>
        </div>
        <input type="submit" value="Add Car">
    </form>
</div>
    <a href="CarServlet">Go Back</a>
    
</body>
</html>
