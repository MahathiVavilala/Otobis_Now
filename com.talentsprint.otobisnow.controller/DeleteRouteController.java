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
* Servlet implementation class Register
*/
@WebServlet("/DeleteRouteController")
public class DeleteRouteController extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public DeleteRouteController() {
    super();
    // TODO Auto-generated constructor stub
}

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse  response)
     */
   

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
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
          //String RegistrationNo = request.getParameter("RegistrationNo");  
          String Route_ID = request.getParameter("Route_ID");  
          
          Class.forName(driver).newInstance();  
          conn = DriverManager.getConnection(url+dbName,"root", "@rtemis143");
         PreparedStatement pst =(PreparedStatement) conn.prepareStatement("delete from Route where Route_ID = '"+Route_ID+"' ");  
        // PreparedStatement pst1 =(PreparedStatement) conn.prepareStatement("delete from Bus where Registration_No = '"+RegistrationNo+"' ");

          //pst.setString(1,RegistrationNo);  
          //pst.setString(2,BusID);        
          

          int i = pst.executeUpdate();
         // int j = pst1.executeUpdate();
          
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