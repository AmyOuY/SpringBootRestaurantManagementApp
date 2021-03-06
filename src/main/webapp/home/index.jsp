<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Index</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/shared/nav.jsp"/>
	
	<br>
	<br>
	<div>
		<c:if test="${logout == true}">
	        <h2 class="text-success text-center">You successfully logout!</h2>
    	</c:if>
	</div>
	<br>
	<br>
	<div class="text-center mt-5">
	    <h1 class="display-5 text-primary">Welcome To Restaurant Management Application</h1>	
	    <h1 class="display-5 text-primary">Please <a href="/login" class="text-danger">login</a> to use the app</h1>	
	</div>	

</body>
</html>