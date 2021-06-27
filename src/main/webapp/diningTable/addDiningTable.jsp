<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Dining Table</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>	
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h2 class="mt-2">Add Dining Table</h2>
			<hr>
			
			<form action="addDiningTable">			
				<div class="form-group row">
					<label for="tableNumber" class="col-sm-2 col-form-label">Table Number</label>
					<div class="col-sm-4">
						<input id="tableNumber" class="form-control" type="text" name="tableNumber">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="seats" class="col-sm-2 col-form-label">Seats</label>
					<div class="col-sm-4">
						<input id="seats" class="form-control" type="text" name="seats">
					</div>
					
				</div>
				
				<div class="form-group row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<input class="btn btn-primary btn-block" type="submit" value="Add">
					</div>
					
				</div>					
			</form>	
			
			<div class="row">
				<a href="/diningTables">Back to Dining Table List</a>
			</div>			
		</div>		
	</body>
</html>