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
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * @see HttpServlet#HttpServlet()
 */
public DeleteController() {
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
          String RegistrationNo = request.getParameter("RegistrationNo");  
          
          Class.forName(driver).newInstance();  
          conn = DriverManager.getConnection(url+dbName,"root", "@rtemis143");
         PreparedStatement pst =(PreparedStatement) conn.prepareStatement("delete from Schedule where Registration_No = '"+RegistrationNo+"' ");  
         System.out.println("Exec");
         PreparedStatement pst1 =(PreparedStatement) conn.prepareStatement("delete from Bus where Registration_No = '"+RegistrationNo+"' ");
         System.out.println("Exec1");
          //pst.setString(1,RegistrationNo);  
          //pst.setString(2,BusID);        
          

          int i = pst.executeUpdate();
          int j = pst1.executeUpdate();
          
          String msg=" ";
         if(j!=0){  
          /*  msg="Record has been inserted";
            pw.print("<font size='6' color=blue>" + msg + "</font>");*/
        	 RequestDispatcher rd = request.getRequestDispatcher("busManagement.jsp");
        	 rd.forward(request,response);


          }  
          else{  
            msg="failed to delete the Bus";
            pw.print("<font size='6' color=blue>" + msg + "</font>");
           }  
          pst.close();
        }  
        catch (Exception e){  
          pw.print(e);  
        }  

}

}