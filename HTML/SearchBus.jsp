<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header> <marquee behavior="alternate"> OtobisNow </marquee> </header>

<head>
<title>Available Buses</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/commonCSS.css">
<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<%
	String src = request.getParameter("source");
	String dest = request.getParameter("destination");
%>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="home.html">Home</a></li>
					<li><a href="About.html">About</a></li>
					<li><a href="Contact.html">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				</ul>

			</div>
		</div>
		</nav>
	</div>

	<div class="jumbotron1">
	<h3><center>Filters</center></h3>
		<form action="SearchController" method="post" align : left>
			<font color="black" size="4"> <center><b>AC/Non AC</b> <input
				list="AC/Non AC" required> <datalist id="AC/Non AC">
				<option value="AC">
				<option value="Non AC">
				</datalist> <label><b>Seating</b> </label> <input list="Seating" required>
				<datalist id="Seating">

				<option value="Sleeper">
				<option value="Non Sleeper">
				</datalist> <br></br>
				<center>
					<button type="submit">Search</button>
				</center>

			</font>
		</form>
	</div>
<br>
	<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/OtobisNow" user="root"
		password="@rtemis143" />

	<sql:query var="listBuses" dataSource="${myDS}">
        select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = "${src}" and R.Destination = "${dest}");

    </sql:query>
	
		<div align="center">
		<div class="jumbotron1">
			<caption>
					<h2><center>List of Buses</center></h2>
				</caption><table  >
				
				<tr>
					<th><center>Registration No</center></th>
					<th>Ac/NonAC</th>
					<th>Seating Type</th>
					<th>Seating Capacity</th>
					<th> Seating Plan </th>
				</tr>
				<c:forEach var="bus" items="${listBuses.rows}">
					<tr>
						<td><center><c:out value="${bus.Registration_No}" /></center></td>
						<td><center><c:out value="${bus.isAC}" /></center></td>
						<td><center><c:out value="${bus.Seating_Type}" /></center></td>
						<td><center><c:out value="${bus.Seatind_Capacity}" /></center></td>
						<td><center><a href="SeatArrangement.html<c:out value='${book.id}' />">View Seats</a></center> </td>
						
                       <!--
                       <button type="button" class="btn btn-success btn-block" onclick = "SeatArrangement.html<c:out value='${bus.Registration_No}' />">View Seats</button> </td> 
                       <a href="SeatArrangement.html<c:out value='${book.id}' />">View Seats</a> </td>
					--></center></tr>
				</c:forEach>
			</table>
		</div>
</div>
	

</body>
<footer> <span class="glyphicon glyphicon-road"></span>5000Routes
<tb>&ensp;&ensp; <span class="glyphicon glyphicon-user"></span>500
Operators</tb> </footer>
</html>

