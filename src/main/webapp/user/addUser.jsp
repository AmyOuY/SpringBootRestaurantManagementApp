<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add User</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
	<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">	
			<h1>Add User</h1>
			<hr>		
			<form action="addUser">		
				<div class="form-group row">
					<label for="userName" class="col-sm-2 col-form-label">User Name</label>
					<div class="col-sm-4">
						<input id="userName" class="form-control" type="text" name="userName">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="password" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-4">
						<input id="password" class="form-control" type="password" name="password">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="active" class="col-sm-2 col-form-label">Active</label>
					<div class="col-sm-4">
						<input id="active" class="form-control" type="checkbox" name="active">
					</div>
					
				</div>
				
				<div class="form-group row">
					<label for="roles" class="col-sm-2 col-form-label">Roles</label>
					<div class="col-sm-4">
						<input id="roles" class="form-control" type="text" name="roles">
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
				<a href="/users">Back to User List</a>
			</div>
			
		</div>
	</body>
</html>