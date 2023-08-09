<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Edit Car Details</title>
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
        <h2>Edit Rental Car Details</h2>
        <form action="EditCarServlet" method="post">
            <div class="form-group">
                <label for="make">Make:</label>
                <input type="text" id="make" name="make" value="${car.make}" required>
            </div>
            <div class="form-group">
                <label for="model">Model:</label>
                <input type="text" id="model" name="model" value="${car.model}" required>
            </div>
            <div class="form-group">
                <label for="model">Years:</label>
                <input type="text" id="years" name="years" value="${car.years}" required>
            </div>
            <div class="form-group">
                <label for="model">Color:</label>
                <input type="text" id="color" name="color" value="${car.color}" required>
            </div>
            <div class="form-group">
                <label for="model">NumberOfDoors:</label>
                <input type="text" id="numberOfDoors" name="numberOfDoors" value="${car.numberOfDoors}" required>
            </div>
            <div class="form-group">
                <label for="model">TransmissionType:</label>
                <input type="text" id="transmissionType" name="transmissionType" value="${car.transmissionType}" required>
            </div>
            <div class="form-group">
                <label for="model">FuelType:</label>
                <input type="text" id="fuelType" name="fuelType" value="${car.fuelType}" required>
            </div>
             <div class="form-group">
                <label for="model">GpsCheck:</label>
                <input type="text" id="gpsCheck" name="gpsCheck" value="${car.gpsCheck}" required>
            </div>
            <input type="hidden" name="carID" value="${car.carID}">
            <input type="submit" value="Save Changes">
        </form>
    </div>
    <a href="CarServlet">Go Back</a>
    
</body>
</html>
