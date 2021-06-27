<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Paid Bills</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
	
		<div class="container">
			<h1 class="text-center">Paid Bills</h1>
			<p class="text-center">
				<a href="/unpaidOrders">Back to Unpaid Order List</a>
			</p>
		
			<table class="table">
				<thead>
					<tr>
						<th>Order ID</th>
						<th>Table Number</th>
						<th>Attendant</th>
						<th>SubTotal</th>
						<th>Tax</th>
						<th>Total</th>				
						<th>Bill Paid</th>						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="displayBill" items="${displayBills}">
						<tr>
				        	<td>${displayBill.orderId}</td>
				        	<td>${displayBill.diningTableNumber}</td>		        	
				        	<td>${displayBill.attendant}</td>	
				        	<td>${displayBill.subTotal}</td>	
				        	<td>${displayBill.tax}</td>	
				        	<td>${displayBill.total}</td>			        	
				        	<td><input type="checkbox" <c:if test="${displayBill.billPaid==true}">checked=checked</c:if>></td>		        	
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>