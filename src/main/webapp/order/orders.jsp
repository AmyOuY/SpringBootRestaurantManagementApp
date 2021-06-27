<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Orders</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<h1 class="text-center">Unpaid Orders By Dining Table</h1>
		<p class="text-center">
			<a href="/getDropdowns">Add Order</a>
		</p>		
	
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Table Number</th>
						<th>Attendant</th>
						<th>SubTotal</th>
						<th>Tax</th>
						<th>Total</th>				
						<th>Created Date</th>	
						<th>Bill Paid</th>				
						<th></th>		
					</tr>
				</thead>
				<tbody>
					<c:forEach var="displayOrder" items="${displayOrders}">
						<tr>
				        	<td>${displayOrder.id}</td>
				        	<td>${displayOrder.diningTableNumber}</td>		        	
				        	<td>${displayOrder.attendant}</td>	
				        	<td>${displayOrder.subTotal}</td>	
				        	<td>${displayOrder.tax}</td>	
				        	<td>${displayOrder.total}</td>			        	
				        	<td>${displayOrder.createdDate}</td>
				        	<td><input type="checkbox" name="billPaid" value="${displayOrder.billPaid}"></td>		        	
				        	<td>
					        	<a href="/order:id=${displayOrder.id}">Detail</a> |    	        		        			        	        	
					        	<a href="/editOrder:id=${displayOrder.id}">Edit</a> |    	        	
					        	<a href="/deleteOrder/${displayOrder.id}">Delete</a>
				        	</td>
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>