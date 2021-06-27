<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Bill</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>	
		<jsp:include page="/shared/nav.jsp"/>
		
		<div class="container">
			<h1>Bill Detail for Table ${bill.diningTableNumber}</h1>
			<hr>
		
			<p><strong class="mr-3">Order ID:</strong>${bill.orderId}</p>
			<p><strong class="mr-3">Table Number: </strong>  ${bill.diningTableNumber}</p>
			<p><strong class="mr-3">Attendant: </strong>  ${bill.attendant}</p>
			<p><strong class="mr-3">SubTotal: </strong>  ${bill.subTotal}</p>
			<p><strong class="mr-3">Tax: </strong>  ${bill.tax}</p>
			<p><strong class="mr-3">Total: </strong>  ${bill.total}</p>
			<label><strong class="mr-3">Bill Paid: </strong><input type="checkbox" name="billPaid" onclick="${bill.billPaid}"></label>
		
			<br>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>Food Name</th>
						<th>Price</th>
						<th>Quantity</th>			
						<th>Created Date</th>				
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderDetail" items="${bill.orderDetails}">
						<tr>
				        	<td>${orderDetail.foodName}</td>	
				        	<td>${orderDetail.price}</td>	
				        	<td>${orderDetail.quantity}</td>	
				        	<td>${orderDetail.createdDate}</td>	
					    </tr>
					</c:forEach>
				</tbody>
			</table>
			
			<form action="payBill">
				<input type="hidden" name="orderId" value="${bill.orderId}">
				<input type="hidden" name="diningTableNumber" value="${bill.diningTableNumber}">
				<input type="hidden" name="attendant" value="${bill.attendant}">
				<input type="hidden" name="subTotal" value="${bill.subTotal}">
				<input type="hidden" name="tax" value="${bill.tax}">
				<input type="hidden" name="total" value="${bill.total}">
				<input type="hidden" name="billPaid" value="${bill.billPaid}">		
				<input class="btn btn-warning" type="submit" value="Pay Bill">
			</form>
			
			<div class="mt-5">
				<a href="/unpaidOrders">Back to Unpaid Order List</a>
			</div>
			
		</div>
	</body>
</html>