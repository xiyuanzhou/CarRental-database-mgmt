<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Edit Customers Details</title>
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
	    <h2>Edit Customer Details</h2>
	    <form action="UpdateCustomerServlet" method="post">
	        <input type="hidden" name="id" value="${customer.id}">
	        <div class="form-group">
	            <label for="customerName">Customer Name:</label>
	            <input type="text" id="customerName" name="customerName" value="${customer.customerName}" required>
	        </div>
	        <div class="form-group">
	            <label for="address">Address:</label>
	            <input type="text" id="address" name="address" value="${customer.address}" required>
	        </div>
	        <div class="form-group">
	            <label for="phone">Phone:</label>
	            <input type="text" id="phone" name="phone" value="${customer.phone}" required>
	        </div>
	        <div class="form-group">
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" value="${customer.email}" required>
	        </div>
	        <input type="submit" value="Save Changes">
	    </form>
	</div>

    <a href="CustomerListServlet">Go Back</a>
    
</body>
</html>
