<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
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
        <h1>Employee List</h1>
        <p><a href="add_employee.jsp">Add Employee</a></p>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Roles</th>
                <th>Salary</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.ename}</td>
                    <td>${employee.address}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.email}</td>
                    <td>${employee.roles}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <a href="EditEmployeeServlet?ID=${employee.id}">Edit</a>
                        <a href="DeleteEmployeeServlet?ID=${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="back-link" href="home.jsp">Back to Home</a>
    </div>
</body>
</html>
