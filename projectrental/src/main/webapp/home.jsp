<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rental Car Home</title>
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
            text-align: center;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .button-group {
            display: flex;
            flex-direction: column;
            gap: 10px;
            margin-top: 20px;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Rental Car Web Management</h1>
        <div class="button-group">
            <form action="${pageContext.request.contextPath}/CarServlet" method="get">
                <button class="button" type="submit">List Rental Car</button>
            </form>
            
            <form action="${pageContext.request.contextPath}/CustomerListServlet" method="get">
                <button class="button" type="submit">List Customers</button>
            </form>
            
            <form action="${pageContext.request.contextPath}/EmployeeListServlet" method="get">
                <button class="button" type="submit">List Employees</button>
            </form>
            
            <form action="${pageContext.request.contextPath}/ReservationListServlet" method="get">
                <button class="button" type="submit">List All Reservations</button>
            </form>
            
            <form action="${pageContext.request.contextPath}/ViewRentalAgreementServlet" method="get">
                <button class="button" type="submit">List Rental Agreements</button>
            </form>
            
            <form action="${pageContext.request.contextPath}/NewRentalAgreementServlet" method="get">
                <button class="button" type="submit">Start Rental Agreement</button>
            </form>
        </div>
    </div>
</body>
</html>


