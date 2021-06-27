<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dining Tables</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
	
		<h1 class="text-center mt-2">All Dining Tables</h1>
		<p class="text-center">
			<a href="/newDiningTable">Add Dining Table</a>
		</p>
				
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Table Number</th>				
						<th>Seats</th>				
						<th></th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach var="diningTable" items="${diningTables}">
						<tr>
				        	<td>${diningTable.id}</td>
				        	<td>${diningTable.tableNumber}</td>		        	
				        	<td>${diningTable.seats}</td>		        		        			        	        	
				        	<td>
					        	<a href="/editDiningTable:id=${diningTable.id}">Edit</a> |  	        	
					        	<a href="/deleteDiningTable/${diningTable.id}">Delete</a>
				        	</td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>