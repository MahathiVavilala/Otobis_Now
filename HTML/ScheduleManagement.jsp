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
<link rel="stylesheet" href="css//commonCSS.css">

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
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li ><a href="busManagement.jsp">Bus Management</a></li>
					<li><a href="RouteManagement.jsp">Route management</a></li>
					<li class="active"><a href="ScheduleManagement.jsp">Schedule Management</a></li>
					
				</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="home.html">Logout</a></li>
			</div>
	
	</nav>
	<div class = jumbotron>
		
		     <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/OtobisNow"
        user="root" password="@rtemis143"
    />
    <sql:query var="listSchedule"   dataSource="${myDS}">
        select * from Schedule;

    </sql:query>
     
    <div align="center">
    <caption><h2>List of schedules</h2></caption>
        <table border="1" cellpadding="5" width = 40% height = 40%>
            <tr>
                <th><center>ScheduleID</center></th>
                <th><center>RouteID</center></th>
                <th><center>RegistrationNo</center></th>
                <th><center>Departure Time</center></th>
                <th><center>Arrival Time</center></th>
                <th><center>Price</center></th>
                          </tr>
            <c:forEach var="schedule" items="${listSchedule.rows}">
                <tr>
                    <td><center><c:out value="${schedule.Schedule_ID}" /></center></td>
                    <td><center><c:out value="${schedule.Route_ID}" /></center></td>
                    <td><center><c:out value="${schedule.Registration_No}" /></center></td>
                    <td><center><c:out value="${schedule.DepartureTime}" /></center></td>
                    <td><center><c:out value="${schedule.ArrivalTime}" /></center></td>
                    <td><center><c:out value="${schedule.Price}" /></center></td>
                   
                </tr>
            </c:forEach>
        </table>
    </div> 
		
		
		

<br></br>
<center>
      <button type="submit"  onclick="location.href='addschedule.jsp'">Add Schedule</button>
	<button type="submit" onclick = "location.href = 'deleteSchedule.jsp'">Delete schedule</a></button></center>
	</div>
	</body>
<footer>
	<span class="glyphicon glyphicon-road"></span>5000Routes
	<tb>&ensp;&ensp; <span class="glyphicon glyphicon-user"></span>500
	Operators</tb>
</footer>
</html>
</html>