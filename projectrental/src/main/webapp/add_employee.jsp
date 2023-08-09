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
	    <h2>Add New Employee</h2>
	    <form action="AddEmployeeServlet" method="post">
	        <div class="form-group">
	            <label for="ename">Employee Name:</label>
	            <input type="text" id="ename" name="ename" required>
	        </div>
	        <div class="form-group">
	            <label for="address">Address:</label>
	            <input type="text" id="address" name="address" required>
	        </div>
	        <div class="form-group">
	            <label for="phone">Phone:</label>
	            <input type="text" id="phone" name="phone" required>
	        </div>
	        <div class="form-group">
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" required>
	        </div>
	        <div class="form-group">
	            <label for="roles">Roles:</label>
	            <input type="text" id="roles" name="roles" required>
	        </div>
	        <div class="form-group">
	            <label for="salary">Salary:</label>
	            <input type="text" id="salary" name="salary" required>
	        </div>
	        <input type="submit" value="Add Employee">
	    </form>
	</div>

    <a href="EmployeeListServlet">Go Back</a>
    
</body>
</html>
