<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>

<%
	System.out.println("BusFilter.jsp");

	String f1 = request.getParameter("p1");
	String f2 = request.getParameter("p2");
	String src = request.getParameter("p3");
	System.out.println("source:" + src);
	String dest = request.getParameter("p4");
	System.out.println("dest:" + dest);

	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OtobisNow", "root", "@rtemis143");
	Statement stmt = con.createStatement();
	System.out.println("connected");
	String query = "";

	if ((f1.length() != 0) && (f2.length() != 0)) {
		System.out.println("if");
		query = " select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and isAC = '" + f1
				+ "' and Seating_Type = '" + f2
				+ "' and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = '"
				+ src + "' and R.Destination = '" + dest + "')";
	} else if ((f1.length() != 0) && (f2.length() == 0)) {
		System.out.println("else if 1");
		query = " select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and isAC = '" + f1
				+ "' and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = '"
				+ src + "' and R.Destination = '" + dest + "')";
	} else if ((f1.length() == 0) && (f2.length() != 0)) {
		System.out.println("else if 2");
		query = " select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and Seating_Type = '" + f2
				+ "' and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = '"
				+ src + "' and R.Destination = '" + dest + "')";
	} else if ((f1.length() == 0) && (f2.length() == 0)) {
		System.out.println("else if 3");
		query = " select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = '"
				+ src + "' and R.Destination = '" + dest + "')";
	}

	ResultSet rs = stmt.executeQuery(query);
%>

<div align="center">
	<div class="jumbotron1">
		
			<h2>
				<center>List of Buses</center>
			</h2>
		
		<table>

			<tr><center>
				<th><center>Registration No</center></th>
				<th><center>AC/NonAC</center></th>
				<th><center>Seating Type</center></th>
				<th><center>Seating Capacity</center></th>
				<th><center>Seating Plan</center></th>
			</tr>

			<%
				while (rs.next()) {
			%>

			<tr>
				<td>
				    <center>
				         <%=rs.getString(1)%>
				    </center>
				</td>
				<td>
				    <center>
				         <%=rs.getString(4)%>
				    </center>
				</td>
				<td>
				    <center>
				         <%=rs.getString(5)%>
				    </center>
				</td>
				<td>
				    <center>
				         <%=rs.getString(6)%>
					</center>
			    </td>
				<td>
				    <center>
						 <a href="SeatArrangement.html">View Seats</a>
					</center>
			    </td>
			</tr>

			<%
				}
			%>
			</table>
			</div>
			</div>
			