<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Create Reservation</title>
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: inline-block;
            width: 150px;
            font-weight: bold;
        }

        select, input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        select {
            width: 100%;
            padding: 8px;
        }

        textarea {
            resize: vertical;
        }

        button, a {
            display: inline-block;
            padding: 8px 15px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
        }

        a {
            margin-left: 10px;
        }

        button[type="submit"] {
            background-color: #28A745;
        }

        button[type="submit"]:hover, a:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create a New Reservation</h2>
        <form action="CreateReservationServlet" method="post">
            <div class="form-group">
                <label for="customerID">Select Customer:</label>
                <select id="customerID" name="customerID" required>
                    <option value="">Select Customer</option>
                    <c:forEach var="customer" items="${availableRentalAgreements}">
                        <option value="${customer.customerID}">${customer.customerID}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="pickupLocation">Pickup Location:</label>
                <input type="text" id="pickupLocation" name="pickupLocation" required>
            </div>
            <div class="form-group">
                <label for="returnLocation">Return Location:</label>
                <input type="text" id="returnLocation" name="returnLocation" required>
            </div>
            <div class="form-group">
                <label for="pickupDate">Pickup Date:</label>
                <input type="date" id="pickupDate" name="pickupDate" required>
            </div>
            <div class="form-group">
                <label for="returnDate">Return Date:</label>
                <input type="date" id="returnDate" name="returnDate" required>
            </div>
            <div class="form-group">
                <label for="carTypePreference">Car Type Preference:</label>
                <select id="carTypePreference" name="carTypePreference">
                    <option value="Economy">Economy</option>
                    <option value="Standard">Standard</option>
                    <option value="Luxury">Luxury</option>
                </select>
            </div>
            <div class="form-group">
                <label for="additionalRequests">Additional Requests:</label>
                <textarea id="additionalRequests" name="additionalRequests" rows="4"></textarea>
            </div>
            <button type="submit">Create Reservation</button>
            <a href="ReservationListServlet">Go Back</a>
        </form>
    </div>
</body>
</html>
