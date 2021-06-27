<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Foods</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<h1 class="text-center">Foods</h1>
		<p class="text-center">
			<a href="/newFood">Add Food</a>
		</p>
		
		<div class="container">
			<table class="table">
				<thead>
				<tr>
					<th>ID</th>
					<th>Food Type</th>				
					<th>Food Name</th>	
					<th>Price</th>				
					<th></th>
				</tr>
				</thead>
				<tbody>
					<c:forEach var="food" items="${foods}">
						<tr>
				        	<td>${food.id}</td>
				        	<td>${food.typeName}</td>		        	
				        	<td>${food.foodName}</td>
				        	<td>${food.price}</td>		        	     		        			        	        	
				        	<td>
					        	<a href="/editFood:id=${food.id}">Edit</a> | 	        	
					        	<a href="/deleteFood/${food.id}">Delete</a>
				        	</td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>