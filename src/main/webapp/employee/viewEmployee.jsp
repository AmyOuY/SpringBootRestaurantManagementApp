<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employee Detail</title>

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">	
			<h2>Employee Detail</h2>
			<hr>
		
			<p><strong class="mr-3">Employee ID:</strong>  ${employee.employeeID}</p>
			<p><strong class="mr-3">First Name:</strong>  ${employee.firstName}</p>
			<p><strong class="mr-3">Last Name:</strong>  ${employee.lastName}</p>
			<p><strong class="mr-3">Email:</strong>  ${employee.email}</p>
			<p><strong class="mr-3">Phone:</strong>  ${employee.phone}</p>
			
			<br>
			<br>
			<a href="/editEmployee:id=${employee.id}">Edit</a> |
			<a href="/employees">Back to Employee List</a>
		</div>
	</body>
		
</html>