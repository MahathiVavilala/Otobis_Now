package com.talentsprint.otobisnow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteScheduleController
 */
@WebServlet("/DeleteScheduleController")
public class DeleteScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteScheduleController() {
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
     // String RegistrationNo = request.getParameter("RegistrationNo");  
      String scheduleID = request.getParameter("ScheduleID");  
      
      Class.forName(driver).newInstance();  
      conn = DriverManager.getConnection(url+dbName,"root", "@rtemis143");
     PreparedStatement pst =(PreparedStatement) conn.prepareStatement("delete from Schedule where Schedule_ID = '"+scheduleID+"'");  
		

     // pst.setString(1,RegistrationNo);  
     // pst.setString(1,scheduleID);        
      

      int i = pst.executeUpdate();
      
      String msg=" ";
     if(i!=0){  
      /*  msg="Record has been inserted";
        pw.print("<font size='6' color=blue>" + msg + "</font>");*/
    	 RequestDispatcher rd = request.getRequestDispatcher("ScheduleManagement.jsp");
    	 rd.forward(request,response);


      }  
      else{  
        msg="failed to delete the Schedule";
        pw.print("<font size='6' color=blue>" + msg + "</font>");
       }  
      pst.close();
    }  
    catch (Exception e){  
      pw.print(e);  
    }  

	}

}
