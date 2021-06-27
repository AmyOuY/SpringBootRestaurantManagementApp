<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>All Order Details</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>		
		<jsp:include page="/shared/nav.jsp"/>
		
		<h1 class="text-center">All Order Details In Record</h1>
	
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Table Number</th>
						<th>Attendant</th>
						<th>Food Name</th>
						<th>Price</th>
						<th>Quantity</th>				
						<th>Created Date</th>	
						<th>Order ID</th>			
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderDetail" items="${displayOrderDetails}">
						<tr>
				        	<td>${orderDetail.id}</td>
				        	<td>${orderDetail.diningTableNumber}</td>		        	
				        	<td>${orderDetail.attendant}</td>	
				        	<td>${orderDetail.foodName}</td>	
				        	<td>${orderDetail.price}</td>	
				        	<td>${orderDetail.quantity}</td>	
				        	<td>${orderDetail.createdDate}</td>	
				        	<td>${orderDetail.orderId}</td>	
					    </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>