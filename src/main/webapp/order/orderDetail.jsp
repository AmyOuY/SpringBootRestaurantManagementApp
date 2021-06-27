<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Order Detail</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">			
			<h2>Order Detail</h2>
			<hr>
				
			<p><strong class="mr-3">ID:</strong>  ${displayOrderDetail.id}</p>
			<p><strong class="mr-3">Table Number:</strong>  ${displayOrderDetail.diningTableNumber}</p>
			<p><strong class="mr-3">Attendant:</strong>  ${displayOrderDetail.attendant}</p>
			<p><strong class="mr-3">Food:</strong>  ${displayOrderDetail.foodName}</p>
			<p><strong class="mr-3">Price:</strong>  ${displayOrderDetail.price}</p>
			<p><strong class="mr-3">Quantity:</strong>  ${displayOrderDetail.quantity}</p>
			<p><strong class="mr-3">Created Date:</strong>  ${displayOrderDetail.createdDate}</p>
			<br>
			<br>
			<br>
			<a href="/editOrderDetail:id=${displayOrderDetail.id}">Edit</a>      |      
			<a href="/orderDetailsByTable?tableNumber=${displayOrderDetail.diningTableNumber}">Back to Order Detail by Table ${displayOrderDetail.diningTableNumber}</a>						
		</div>	
	</body>
</html>