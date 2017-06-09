package com.talentsprint.otobisnow.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.talentsprint.otobisnow.bean.BusBean;
import com.talentsprint.otobisnow.util.Bus;
import com.talentsprint.otobisnow.util.User;

import sun.util.calendar.BaseCalendar.Date;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String source = request.getParameter("src");
		String destination = request.getParameter("dest");
		String date = request.getParameter("dt");

		if (BusBean.isBus(source, destination)) {
			out.println("Exists");
			request.setAttribute("src", source);
			request.setAttribute("dest", destination);
			
			RequestDispatcher rs = request.getRequestDispatcher("SearchBus.jsp");
			rs.forward(request, response);
		} else {
			out.println("Buses are not available");
			RequestDispatcher rs = request.getRequestDispatcher("homeAfterLogin.html");
			rs.include(request, response);
		}
	}

}
