<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Reservation List</title>
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
        .add-button {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            margin-bottom: 20px;
            cursor: pointer;
            border-radius: 4px;
            font-size: 14px;
        }
        .add-button:hover {
            background-color: #0056b3;
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
        <h1>Reservation List</h1>
        <form action="${pageContext.request.contextPath}/AddReservationFormServlet" method="get">
            <button class="add-button" type="submit">Add Reservation</button>
        </form>
        <table>
            <tr>
                <th>Reservation ID</th>
                <th>Customer ID</th>
                <th>Customer Name</th>
                <th>Pickup Location</th>
                <th>Return Location</th>
                <th>Pickup Date</th>
                <th>Return Date</th>
                <th>Car Type Preference</th>
                <th>Additional Requests</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${reservationList}" var="reservation">
                <tr>
                    <td>${reservation.id}</td>
                    <td>${reservation.customerID}</td>
                    <td>${reservation.customerName}</td>
                    <td>${reservation.pickupLocation}</td>
                    <td>${reservation.returnLocation}</td>
                    <td>${reservation.pickupDate}</td>
                    <td>${reservation.returnDate}</td>
                    <td>${reservation.carTypePreference}</td>
                    <td>${reservation.additionalRequests}</td>
                    <td>
                        <a href="DeleteReservationServlet?id=${reservation.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="back-link" href="home.jsp">Back to Home</a>
    </div>
</body>
</html>
