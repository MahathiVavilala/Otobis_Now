
package com.talentsprint.otobisnow.controller;

import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.talentsprint.otobisnow.util.MysqlConnection;
import com.talentsprint.otobisnow.util.User;  
@WebServlet("/SignUp") 
public class SignUp extends HttpServlet { 
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String email = request.getParameter("usrname"); 
String firstName = request.getParameter("firstName");  
String lastName = request.getParameter("lastName"); 
String password = request.getParameter("psw");  
String repeatPassword = request.getParameter("psw-repeat");
String mobileNumber = request.getParameter("Mobile Number");  

if (User.canAddUser(email, firstName, lastName, password, mobileNumber)) {
	
	RequestDispatcher rs = request.getRequestDispatcher("home.html");
	out.println("Successfully Registered!!");
	rs.forward(request, response);
} else {
	out.println("Please enter valid credentials!!");
	RequestDispatcher rs = request.getRequestDispatcher("SignUp.html");
	rs.include(request, response);
}
          
}
}