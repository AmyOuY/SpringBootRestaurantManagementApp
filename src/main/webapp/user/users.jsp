<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Users</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<jsp:include page="/shared/nav.jsp"/>
			
			<h1 class="text-center">All Users</h1>
			<p class="text-center">
				<a href="/newUser">Add User</a>
			</p>
					
			<div class="container">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>User Name</th>
							<th>Password</th>				
							<th>Roles</th>	
							<th>Active</th>				
							<th></th>		
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.id}</td>
					        	<td>${user.username}</td>
					        	<td>${user.password}</td>		        						        	
					        	<td>${user.roles}</td>	
					        	<td>${user.active}</td>	        	
					        	<td>	        		        			        	        	
						        	<a href="/editUser:id=${user.id}">Edit</a> |  	        	
						        	<a href="/deleteUser/${user.id}">Delete</a>
					        	</td>
						    </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	</body>
</html>