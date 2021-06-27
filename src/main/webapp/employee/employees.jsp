<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Employees</title>

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<h1 class="text-center">All Employees</h1>
		<p class="text-center">
			<a href="/newEmployee">Add Employee</a>
		</p>
				
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Employee ID</th>
						<th>First Name</th>				
						<th>Last Name</th>	
						<th>Email</th>				
						<th>Phone</th>			
						<th></th>		
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employees}">
						<tr>
							<td>${employee.id}</td>
				        	<td>${employee.employeeID}</td>
				        	<td>${employee.firstName}</td>		        	
				        	<td>${employee.lastName}</td>
				        	<td>${employee.email}</td>		        	
				        	<td>${employee.phone}</td>
				        	<td>
					        	<a href="/employee:id=${employee.id}">Detail</a> |  			        		        			        	        	
					        	<a href="/editEmployee:id=${employee.id}">Edit</a> |  	        	
					        	<a href="/deleteEmployee/${employee.id}">Delete</a>
				        	</td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>