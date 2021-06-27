<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Employee</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>	
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">	
			<h1>Edit Employee</h1>
			<hr>		
			<form action="updateEmployee">		
				<div class="form-group row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-4">
						<input id="id" class="form-control" type="text" name="id" value="${employee.id}" readonly>
					</div>
				</div>
				<div class="form-group row">
					<label for="employeeID" class="col-sm-2 col-form-label">Employee ID</label>
					<div class="col-sm-4">
						<input id="employeeID" class="form-control" type="text" name="employeeID" value="${employee.employeeID}">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="firstName" class="col-sm-2 col-form-label">First Name</label>
					<div class="col-sm-4">
						<input id="firstName" class="form-control" type="text" name="firstName" value="${employee.firstName}">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
					<div class="col-sm-4">
						<input id="lastName" class="form-control" type="text" name="lastName" value="${employee.lastName}">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-4">
						<input id="email" class="form-control" type="text" name="email" value="${employee.email}">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="phone" class="col-sm-2 col-form-label">Phone</label>
					<div class="col-sm-4">
						<input id="phone" class="form-control" type="text" name="phone" value="${employee.phone}">
					</div>
					
				</div>
				
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<input class="btn btn-primary btn-block" type="submit" value="Save">
					</div>
					
				</div>		
			</form>	
			
			<div class="row">
				<a href="/employees">Back to Employee List</a>
			</div>
			
		</div>
	</body>
</html>