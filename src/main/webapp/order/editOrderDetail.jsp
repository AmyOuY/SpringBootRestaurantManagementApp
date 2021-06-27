<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Order Detail</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h2>Edit Order Detail</h2>
			<hr>
			
			<form action="updateOrderDetail">		
				<div class="form-group row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-4">
						<input id="id" class="form-control" type="number" name="id" value="${displayOrderDetail.id}" readonly>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="diningTableNumber" class="col-sm-2 col-form-label">Table Number</label>
					<div class="col-sm-4">
						<input id="diningTableNumber" class="form-control" type="number" name="diningTableNumber" value="${displayOrderDetail.diningTableNumber}">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="attendant" class="col-sm-2 col-form-label">Attendant</label>
					<div class="col-sm-4">
						<input id="attendant" class="form-control" type="text" name="attendant" value="${displayOrderDetail.attendant}">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="foodName" class="col-sm-2 col-form-label">Food</label>
					<div class="col-sm-4">
						<input id="foodName" class="form-control" type="text" name="foodName" value="${displayOrderDetail.foodName}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="price" class="col-sm-2 col-form-label">Price</label>
					<div class="col-sm-4">
						<input id="price" class="form-control" type="text" name="price" value="${displayOrderDetail.price}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
					<div class="col-sm-4">
						<input id="quantity" class="form-control" type="number" name="quantity" value="${displayOrderDetail.quantity}">
					</div>					
				</div>
				
				<div>
					<input type="hidden" name="orderId" value="${displayOrderDetail.orderId}"> 
				</div>
			
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<input class="btn btn-primary btn-block" type="submit" value="Save">
					</div>					
				</div>					
			</form>	
			
			<div class="row">
				<a href="/orderDetailsByTable?tableNumber=${displayOrderDetail.diningTableNumber}">Back to Order Detail by Table ${displayOrderDetail.diningTableNumber}</a>
	
			</div>			
		</div>					
	</body>
</html>