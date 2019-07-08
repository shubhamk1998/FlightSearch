<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nagarro.flights.models.Flights"%>
<% List<Flights> eList = (List)session.getAttribute("flights");%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Full-width input fields */

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 5% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
<title>Login Page</title>
</head>
<script type="text/javascript">
var msg="${m}";
console.log(msg);

if(msg === "false") {
	alert("Wrong Credentials");
<%     session.removeAttribute("authorized");
 %>
}

</script>
<body>

	<form class="modal-content animate" action="search" method="post">
		<div class="imgcontainer">
			<h5>Search</h5>
		</div>

		<div class="container">
		<div class="row">
		<div class="col-4">
		<input type="text" class="form-control"
				placeholder="Enter Departure Location" name="deploc" maxlength="3" required>
		</div>
			
			<div class="col-4">
		<input class="form-control" type="text" placeholder="Enter Arrival Location"
				name="arrloc" maxlength="3" required> 
		</div>
		
		<div class="col-4">
	
	<select name="fclass" class="form-control">
	    <option value="">Select Class</option>
  		<option value="E">Economy</option>
  		<option value="B">Business</option>
	</select>
	</div>
		
	<br>
	</div>
	<div class="row">
	<div class="col-6">
	<label>Enter Flight Date</label>
					<input placeholder="Enter Date"  type="date" name="date" class="form-control" required>	
	 
	</div>
	<div class="col-6">
	<label for="psw"><b>Sort By</b></label> 
	
	<select name="sort" class="form-control">
	    <option value="">Select Option</option>
  		<option value="1">Sort By Fare</option>
  		<option value="2">Sort By Fare And Duration</option>
	</select>
	</div>
	</div>
	
				


				

			<button type="submit">Search</button>

		</div>

	</form>
<div class="container-fluid">
<div class="col">
	
			<%
                                   if(eList!=null&&eList.size()>0) {
                                	   %>
                                	   
                                	   <table class="table">
	<thead class="thead-dark">
    <tr>
      <th scope="col">Flight No</th>
            <th scope="col">Dep</th>
            <th scope="col">Arr</th>
      
      <th scope="col">Fare</th>
      <th scope="col">Duration(Hours)</th>
            <th scope="col">Time</th>
                        <th scope="col">Flight Class</th>
            
      
    </tr>
  </thead>
		<tbody> 
		<%
                                	   
                                	   
                                        for (Flights flight : eList) {
                                %>
			<!-- This will be in a for loop for all the images there are  -->
			<tr>

				<td><%=flight.getflightNo()%></td>
								<td><%=flight.getdep()%></td>
								<td><%=flight.getarr()%></td>
				
				<td><%=flight.getfare()%></td>
				<td><%=flight.getflightDur()%></td>
				<td><%=flight.getflightTime()%></td>
								<td><%=flight.getclass()%></td>
				
			</tr>

			<% } %>
		</tbody>
	</table>

<%}
                                   if(eList!=null) {
			%>
			<div class="container-fluid" style="text-align:Center">
			<h3>No Flights Found</h3>
			</div>
			<%} %>
</div>
</div>
</body>
</html>