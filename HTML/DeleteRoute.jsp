<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<header>
	<marquee behavior="alternate">OtobisNow</marquee>
</header>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/commonCSS.css">
<script type="text/javascript" src="form.js"></script>
<script src="email-validation.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Deleting Existing Route</title>
<link rel="stylesheet" href="commonCSS.css">
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
					
					<li><a href="busManagement.jsp">Bus Management</a></li>
					<li><a href="RouteManagement">Route management</a></li>
					<li><a href="ScheduleManagement.jsp">Schedule Management</a></li>
					
				</ul>
<ul class="nav navbar-nav navbar-right">
<li><a href="home.html">Logout</a></li>
			</div>
	
	</nav>


<form name="deleting the bus details" action="DeleteRouteController" method="post">
<h1><center>Deleting a Route</center></h1>
<div class  = jumbotron>
Route ID: <input type="text" name="Route_ID"><br>


<button type = "submit" value = "submit" name = "Delete">Delete Route
</button>
</div>
</form>
</body>
</html>