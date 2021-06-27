<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Food</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>	
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h2>Add Food</h2>
			<hr>
			
			<form action="addFood">			
				<div class="form-group row">
					<label for="typeName" class="col-sm-2 col-form-label">Food Type</label>
					<div class="col-sm-4">
						<input id="typeName" class="form-control" type="text" name="typeName">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="foodName" class="col-sm-2 col-form-label">Food Name</label>
					<div class="col-sm-4">
						<input id="foodName" class="form-control" type="text" name="foodName">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="price" class="col-sm-2 col-form-label">Price</label>
					<div class="col-sm-4">
						<input id="price" class="form-control" type="text" name="price">
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
				<a href="/foods">Back to Food List</a>
			</div>			
		</div>		
	</body>
</html>