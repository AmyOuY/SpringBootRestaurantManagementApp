<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Search Bill</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<div class="row">
		        <div class="col-4"></div>
		        <div class="col-4">
		        	<h2 class="mt-5 mb-5">Search Bill By Table</h2>
		        	<hr>
		            <form action="/billByTable">
		                <div class="form-group">
		                    <label for="tableNumber" class="h5">Table number: </label>
		                    <input id="tableNumber" name="tableNumber" />
		                </div>
		                <div class="form-group text-center">
		                    <input type="submit" value="View Bill" class="btn btn-success" />
		                </div>
	            	</form>
		        </div>
		        <div class="col-4"></div>		   
			</div>
		</div>
	</body>
</html>