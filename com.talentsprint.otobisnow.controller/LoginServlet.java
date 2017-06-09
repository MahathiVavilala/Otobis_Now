package com.talentsprint.otobisnow.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.talentsprint.otobisnow.bean.EmpLogin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
     
        EmpLogin login = new EmpLogin();
        login.setEmail(email);
        login.setPassword(password);
        @SuppressWarnings("unused")
		PrintWriter out1 = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("email" , email );
        
        //HttpSession session = request.getSession();
     
        if(login.validateCredentials(email, password)) {
        	    HttpSession session1 = request.getSession(true);
        	    session1.setAttribute("currentSessionUser" , login);
        	    System.out.println("Succesfull!!!");
        		response.sendRedirect("homeAfterLogin.html");
        } else {
        	//out.println("Invalid Credentials!!!");
        	out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect');");
            out.println("</script>");
        	RequestDispatcher r = request.getRequestDispatcher("home.html");
        	r.include(request, response);
        	
        }
    }  
}