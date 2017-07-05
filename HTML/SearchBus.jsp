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


<body onload="applyFilter()">
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
		<center> 
	
		<% 
			String source = (String)request.getAttribute("src"); 
			String dest = (String)request.getAttribute("dest");
		%>
		
		<input type="hidden" id="source" value="<%= source %>">
		<input type="hidden" id="dest" value="<%= dest %>">
		<font color="black" size="4"> <b>AC/Non AC</b> 
		
				<select id="ACType" >
				//<option value="">Select a type</option>
				<option value="1">AC</option>
				<option value="0"> NonAC</option>
				</select> <label><b>Seating</b> </label>
				<select id="Seating">
//<option value="">Select a type</option>
				<option value="Sleeper">Sleeper</option>
				<option value="NonSleeper">NonSleeper</option>
				</select> <br></br>
				</center>
					<center><button type="submit" width = "10" onclick="applyFilter()">Apply Filter	</button></center>
				</center>

			</font>
		</form>
	</div>
<br>
<div id="results"></div>
	
	
<script>
	function applyFilter() {
		var filter1 = document.getElementById("ACType");
		var filter2 = document.getElementById("Seating");
		var src = document.getElementById("source").value;
		var dest = document.getElementById("dest").value;
		var str1 = filter1.options[filter1.selectedIndex].value;
		var str2 = filter2.options[filter2.selectedIndex].value;
		
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if(this.readyState == 4 && this.status == 200) {
				var resp = this.responseText;
			
				document.getElementById("results").innerHTML = resp;
			}
		};
	
		xhttp.open("GET","BusFilter.jsp?p1="+str1+"&p2="+str2+"&p3="+src+"&p4="+dest,true);
		xhttp.send();
	}
</script>
</body>
<footer> <span class="glyphicon glyphicon-road"></span>5000Routes
<tb>&ensp;&ensp; <span class="glyphicon glyphicon-user"></span>500Operators</tb> </footer>
</html>

