<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>View All Rental Agreements</title>
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
        h2 {
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
        <h2>View All Rental Agreements</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Rental Start</th>
                <th>Rental End</th>
                <th>Total Cost</th>
                <th>Status</th>
                <th>Customer Name</th>
                <th>Employee Name</th>
                <th>Car Make</th>
                <th>Car Model</th>
                <th>Additional Requests</th>
            </tr>
            <c:forEach var="rentalAgreement" items="${rentalAgreements}">
                <tr>
                    <td>${rentalAgreement.id}</td>
                    <td>${rentalAgreement.rentalStart}</td>
                    <td>${rentalAgreement.rentalEnd}</td>
                    <td>${rentalAgreement.totalCost}</td>
                    <td>${rentalAgreement.status}</td>
                    <td>${rentalAgreement.customerName}</td>
                    <td>${rentalAgreement.employeeName}</td>
                    <td>${rentalAgreement.carMake}</td>
                    <td>${rentalAgreement.carModel}</td>
                    <td>${rentalAgreement.additionalRequests}</td>
                </tr>
            </c:forEach>
        </table>
        <a class="back-link" href="CarServlet">Go Back to Car List</a>
    </div>
</body>
</html>
