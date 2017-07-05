package com.talentsprint.otobisnow.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.talentsprint.otobisnow.util.Bus;
import com.talentsprint.otobisnow.util.MysqlConnection;
import com.talentsprint.otobisnow.util.User;

/**
 * Servlet implementation class AddBusController
 */
@WebServlet("/AddBusController")
public class AddBusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBusController() {
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

		String registrationNo = request.getParameter("RegistrationNo");
		String busTypeID = request.getParameter("BusID");
		String isAC = request.getParameter("isAC");
		String seatingType = request.getParameter("SeatingType");
		String seatingCapacity = request.getParameter("SeatingCapacity");

		if (Bus.canAddBus(registrationNo,busTypeID,Integer.parseInt(isAC),seatingType,Integer.parseInt(seatingCapacity))) {
			out.println("Welcome User");
			RequestDispatcher rs = request.getRequestDispatcher("busManagement.jsp");
			rs.forward(request, response);
		} else {
			out.println("Incorrect Id or Password");
			RequestDispatcher rs = request.getRequestDispatcher("home.html");
			rs.include(request, response);
		}
	}


	}

	
