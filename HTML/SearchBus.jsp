<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
	<marquee behavior="alternate"> OtobisNow </marquee>
</header>

<head>
<title>Available Buses</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/commonCSS.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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

	<div class="jumbotron">
		<form action = "SearchController" method = "post" align : left>
			<font color="black" size="4"> <b>AC/Non AC</b> <input
				list="AC/Non AC" required> 
				<datalist id="AC/Non AC">
					<option value="AC">
					<option value="Non AC">
				</datalist> 
				 
				<label><b>Seating</b>
				 </label> 
				<input list="Seating" required> 
				<datalist id="Seating">

					<option value="Sleeper">
					<option value="Non Sleeper">
				</datalist> <br></br>
				<center><button type="submit">Search</button></center>
				</font>
		</form>
		
		     <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/OtobisNow"
        user="root" password="@rtemis143"
    />
     
    <sql:query var="listBuses"   dataSource="${myDS}">
        select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and isAC = 1 and Seating_Type = "Non-Sleepe" and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = "Hyderabad" and R.Destination = "Guntur");

    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Buses</h2></caption>
            <tr>
                <th>Registration No</th>
                <th>Ac/NonAC</th>
                <th>Seating Type</th>
                <th>Seating Capacity</th>
            </tr>
            <c:forEach var="bus" items="${listBuses.rows}">
                <tr>
                    <td><c:out value="${bus.Registration_No}" /></td>
                    <td><c:out value="${bus.isAC}" /></td>
                    <td><c:out value="${bus.Seating_Type}" /></td>
                    <td><c:out value="${bus.Seatind_Capacity}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
		
		</div>
		
</body>
<footer>
	<span class="glyphicon glyphicon-road"></span>5000Routes
	<tb>&ensp;&ensp; <span class="glyphicon glyphicon-user"></span>500
	Operators</tb>
</footer>
</html>

