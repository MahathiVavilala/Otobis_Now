package com.talentsprint.otobisnow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.talentsprint.otobisnow.dao.AdminDAO;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("user");
		String password = request.getParameter("pass");
	    
		AdminDAO admin = new AdminDAO();
		 if(admin.isAdmin(uname,password)) {
			  //out.print("true");
			RequestDispatcher rd = request.getRequestDispatcher("homeAfterLogin.html");
			rd.forward(request, response);  
			
		} else {
			out.print("Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("AdminFront.html");
			rd.forward(request, response);
		} 
	}

}