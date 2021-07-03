<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container row">
			<div class="col-3"></div>
			<div class="col-6">
				<h2 class="mt-2 text-center">Login</h2>
				<hr>
				<div>				    
			        <div>
					    <c:if test="${error == true}">
					        <h3 class="text-danger text-center">Invalid username and password</h3>
					    </c:if>
					</div>
				    
				</div>
				<form action="/login" method="POST">			
					<div class="form-group">					
						<input class="form-control" type="text" name="username" placeholder="Username">					
					</div>
					
					<div class="form-group">
						<input class="form-control" type="password" name="password" placeholder="Password">
					</div>
					
					<div class="form-group">				
						<input class="btn btn-primary btn-block" type="submit" name="submit" value="Sign in">
					</div>					
				</form>				
			</div>			
			<div class="col-3"></div>
		</div>
	</body>
</html>