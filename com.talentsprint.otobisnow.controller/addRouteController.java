package com.talentsprint.otobisnow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.*;
/**
/**
 * Servlet implementation class addRouteController
 */
@WebServlet("/addRouteController")
public class addRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
         PrintWriter pw = response.getWriter(); 
         //String connectionURL = "jdbc:mysql://127.0.0.1:3306/newData";// newData is the database  
         //Connection connection;  
         Connection conn=null;
         String url="jdbc:mysql://localhost:3306/";
         String dbName="OtobisNow";
         String driver="com.mysql.jdbc.Driver";
     //String dbUserName="root";
     //String dbPassword="root";

     try{  
      
    	 String rId = request.getParameter("Route_ID");
 		String src = request.getParameter("Source");
 		String dest = request.getParameter("Destination");
 		String dist = request.getParameter("Distance");
 
       
       Class.forName(driver).newInstance();  
       conn = DriverManager.getConnection(url+dbName,"root", "@rtemis143");
       PreparedStatement pst =(PreparedStatement) conn.prepareStatement("insert into Route values(?,?,?,?) ");  

       pst.setString(1,rId);  
       pst.setString(2,src);   
       pst.setString(3,dest);
       pst.setString(4,dist);
       

       int i = pst.executeUpdate();
       
       String msg=" ";
      if(i!=0){  
       /*  msg="Record has been inserted";
         pw.print("<font size='6' color=blue>" + msg + "</font>");*/
     	 RequestDispatcher rd = request.getRequestDispatcher("RouteManagement.jsp");
     	 rd.forward(request,response);


       }  
       else{  
         msg="failed to insert the data";
         pw.print("<font size='6' color=blue>" + msg + "</font>");
        }  
       pst.close();
     }  
     catch (Exception e){  
       pw.print(e);  
     }  
	}
}

	

	
