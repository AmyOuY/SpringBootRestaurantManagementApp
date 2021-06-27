<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Order</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h2>Edit Order</h2>
			<hr>
			
			<form action="updateOrder">		
				<div class="form-group row">
					<label for="id" class="col-sm-2 col-form-label">ID</label>
					<div class="col-sm-4">
						<input id="id" class="form-control" type="number" name="id" value="${displayOrder.id}" readonly>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="diningTableNumber" class="col-sm-2 col-form-label">Table Number</label>
					<div class="col-sm-4">
						<input id="diningTableNumber" class="form-control" type="number" name="diningTableNumber" value="${displayOrder.diningTableNumber}">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="attendant" class="col-sm-2 col-form-label">Attendant</label>
					<div class="col-sm-4">
						<input id="attendant" class="form-control" type="text" name="attendant" value="${displayOrder.attendant}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="subTotal" class="col-sm-2 col-form-label">SubTotal</label>
					<div class="col-sm-4">
						<input id="subTotal" class="form-control" type="text" name="subTotal" value="${displayOrder.subTotal}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="tax" class="col-sm-2 col-form-label">Tax</label>
					<div class="col-sm-4">
						<input id="tax" class="form-control" type="text" name="tax" value="${displayOrder.tax}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="total" class="col-sm-2 col-form-label">Total</label>
					<div class="col-sm-4">
						<input id="total" class="form-control" type="text" name="total" value="${displayOrder.total}">
					</div>					
				</div>
				
				<div class="form-group row">
					<label for="billPaid" class="col-sm-2 col-form-label">Bill Paid</label>
					<div class="col-sm-4">
						<input id="billPaid" class="form-control" type="checkbox" name="billPaid" onclick="${displayOrder.billPaid}">
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
				<a href="/unpaidOrders">Back to Unpaid Order List</a>
			</div>			
		</div>			
	</body>
</html>