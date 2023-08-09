<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create a New Car Rental Agreement</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background: url('arrow-down.png') no-repeat right center;
            background-size: 20px;
            padding-right: 30px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
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
        <h2>Create a New Car Rental Agreement</h2>
        <form action="CreateRentalAgreementServlet" method="post">
            <div class="form-group">
                <label for="rentalStart">Rental Start Date:</label>
                <input type="date" id="rentalStart" name="rentalStart" required>
            </div>
            <div class="form-group">
                <label for="rentalEnd">Rental End Date:</label>
                <input type="date" id="rentalEnd" name="rentalEnd" required>
            </div>
            <div class="form-group">
                <label for="totalCost">Total Cost:</label>
                <input type="text" id="totalCost" name="totalCost" required>
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status" required>
                    <option value="Active">Active</option>
                    <option value="Completed">Completed</option>
                    <option value="Canceled">Canceled</option>
                </select>
            </div>
            <div class="form-group">
                <label for="carID">Select Car:</label>
                <select id="carID" name="carID" required>
                    <option value="">Select Car</option>
                    <c:forEach var="car" items="${availableCars}">
                        <option value="${car.carID}">${car.make} ${car.model}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="customerID">Select Customer:</label>
                <select id="customerID" name="customerID" required>
                    <option value="">Select Customer</option>
                    <c:forEach var="customer" items="${allCustomers}">
                        <option value="${customer.id}">${customer.customerName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="operatorID">Select Operator:</label>
                <select id="operatorID" name="operatorID" required>
                    <option value="">Select Operator</option>
                    <c:forEach var="operator" items="${allOperators}">
                        <option value="${operator.id}">${operator.ename}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Save Rental Agreement">
        </form>
        <a class="back-link" href="home.jsp">Back to Home</a>
    </div>
</body>
</html>
