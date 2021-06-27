<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Food Order</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>	
		<jsp:include page="/shared/nav.jsp"/>
					
		<div class="row">
		    <div class="col-md-2"></div>
		    <div class="col-md-6">		    
		    	<h2>Add Food Order</h2>
				<hr>
				
		    	<form action="/addOrderDetail">		
					<div class="form-group row">
						<label for="diningTable" class="col-sm-2 col-form-label">Table Number</label>
						<div class="col-sm-4">
							<select id="diningTable" name="diningTable">
								<option value="null">--select--<option>
							  	<c:forEach items="${diningTables}" var="diningTable">
								    <option value="${diningTable.tableNumber}">
								        ${diningTable.tableNumber}
								    </option>
							  	</c:forEach>
							</select>
						</div>
					</div>
					
					
					<div class="form-group row">
						<label for="employee" class="col-sm-2 col-form-label">Attendant</label>
						<div class="col-sm-4">
							<select id="employee" name="employee">
								<option value="null">--select--</option>
							  	<c:forEach items="${employees}" var="employee">
								    <option value="${employee.firstName} ${employee.lastName}">
								        ${employee.firstName} ${employee.lastName}
								    </option>
							  	</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="foodType" class="col-sm-2 col-form-label">Food Type</label>
						<div class="col-sm-4">
							<select id="foodType" name="foodType">
								<option value="null">--select--</option>
							  	<c:forEach items="${foodTypes}" var="foodType">
								    <option value="${foodType.id}">
								        ${foodType.typeName}
								    </option>
							  	</c:forEach>
							</select>
						</div>
					</div>
					
					
					<div class="form-group row">
						<label for="foodName" class="col-sm-2 col-form-label">Food Name</label>
						<div class="col-sm-4">
							<select id="foodName" name="foodName">
								<option value="null">--select--</option>
							  	<c:forEach items="${foods}" var="food">
								    <option value="${food.foodName}">
								        ${food.foodName}
								    </option>
							  	</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="price" class="col-sm-2 col-form-label">Price</label>
						<div class="col-sm-4">
							<input id="price" class="form-control" type="text" name="price">
						</div>					
					</div>
					
					
					<div class="form-group row">
						<label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
						<div class="col-sm-4">
							<input id="quantity" class="form-control" type="number" name="quantity">
						</div>					
					</div>
					
					<div class="form-group row">
						<div class="col-sm-2"></div>
						<div class="col-sm-4">
							<input class="btn btn-primary btn-block" type="submit" value="Add">
						</div>					
					</div>	
					
				</form>
	    	</div>
	    	
	    	<div class="col-md-2">
	    		<div class="row mt-lg-5"></div>
		        <div class="row mt-lg-5"></div>
		        <div class="row mt-lg-5"></div>
		        
		        <form action="/orderDetailsByTable">
		            <div class="form-group">
		                <label for="tNumber" class="h5">Table number: </label>
		                <input id="tNumber" name="tableNumber" />
		            </div>
		            <div class="form-group text-center">
		                <input type="submit" value="View Order Detail" class="btn btn-primary" />
		            </div>
		        </form>
		        
		        <div class="row mt-lg-5"></div>
		        <div class="row mt-lg-5"></div>
		        <a href="/unpaidOrders">Back to Unpaid Order List</a>		        
	    	</div>
		    		
    	</div>
		  
		 
		<script type="text/javascript">	
			$(document).ready(function () {
				$("#foodType").change(function () {
					var typeId = $(this).val();
				    $.ajax({
				        type: "GET",
				        url: "/getFoodsByTypeId/" + typeId,
				        success: function(data){
				            var foodName=$("#foodName"), option="";
				            foodName.empty();
				            
				            option += "<option value=" + null + ">" + "--select--" + "</option>";
		
				            for(var i=0; i<data.length; i++){
				                option += "<option value='"+data[i].id + "'>"+data[i].foodName + "</option>";
				            }
				            
				            foodName.append(option);
				        },
				        
				        error:function(){
				            alert("error");
				        }
				    });
		
		        });
				
				
				$("#foodName").change(function () {
					var id = $(this).val();
				    $.ajax({
				        type: "GET",
				        url: "/getFoodById/" + id,
				        success: function(data){
				           $("#price").empty();		            
				           $("#price").val(data["price"]);
				        },
				        
				        error:function(){
				            alert("error");
				        }
				    });
		
		        });
		    });
		</script>
	</body>
	
</html>