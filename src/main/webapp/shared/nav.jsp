<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Navigation</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
	  		<a class="navbar-brand" href="/">Restaurant Management</a>
	  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    		<span class="navbar-toggler-icon"></span>
	  		</button>
	
	  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
	    		<ul class="navbar-nav mr-auto">
	      			<li class="nav-item active">
	        			<a class="nav-link" href="/">Home</a>
	      			</li>
				    
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Employees
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/newEmployee">Add Employee</a>
				            <a class="dropdown-item" href="/employees">Employees</a>
				        </div>
	      			</li>
	      			
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Foods
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/newFoodType">Add Food Type</a>
				            <a class="dropdown-item" href="/foodTypes">Food Types</a>
				            <a class="dropdown-item" href="/newFood">Add Food</a>
				            <a class="dropdown-item" href="/foods">Foods</a>
				        </div>
	      			</li>
	      			
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Dining Tables
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/newDiningTable">Add Dining Table</a>
				            <a class="dropdown-item" href="/diningTables">Dining Tables</a>
				        </div>
	      			</li>
	      			
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Orders
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/getDropdowns">Create Order</a>
				            <a class="dropdown-item" href="/searchOrderByTable">Search Order</a>
				            <a class="dropdown-item" href="/unpaidOrders">Unpaid Orders</a>
				        </div>
	      			</li>
	      			
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Bills
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/searchBillByTable">Search Bill</a>
				            <a class="dropdown-item" href="/paidBills">Bills</a>
				        </div>
	      			</li>
	      			
	      			<li class="nav-item dropdown">
	        			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				            Records
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
				            <a class="dropdown-item" href="/allOrders">All Orders</a>
				            <a class="dropdown-item" href="/allOrderDetails">All Order Details</a>
				        </div>
	      			</li>
	      
	    		</ul>
	  		</div>
		</nav>
		<br>
	</body>
</html>