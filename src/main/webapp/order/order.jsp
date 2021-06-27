<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Order</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h2>Order</h2>
			<hr>
		
			<p><strong class="mr-3">ID:</strong>  ${displayOrder.id}</p>
			<p><strong class="mr-3">Table Number:</strong>  ${displayOrder.diningTableNumber}</p>
			<p><strong class="mr-3">Attendant:</strong>  ${displayOrder.attendant}</p>
			<p><strong class="mr-3">SubTotal:</strong>  ${displayOrder.subTotal}</p>
			<p><strong class="mr-3">Tax:</strong>  ${displayOrder.tax}</p>
			<p><strong class="mr-3">Total:</strong>  ${displayOrder.total}</p>
			<p><strong class="mr-3">Created Date:</strong>  ${displayOrder.createdDate}</p>
			<label><strong class="mr-3">Bill Paid: </strong><input type="checkbox" name="billPaid" onclick="${displayOrder.billPaid}"></label><br>
			
			<br>
			<br>			
			<a href="/unpaidOrders">Back to Unpaid Order List</a>
		</div>	
	</body>
</html>