package com.talentsprint.otobisnow.bean;



import java.sql.*;

import com.talentsprint.otobisnow.util.MysqlConnection;

public class EmpLogin {
	private String email;
	//private String empName;
	private String password;
	/**private String designation;
	private String address;
	private String email;
	private String contact;*/
	
	
	/**public String getEmail() {
		return email;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}*/
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateCredentials(String email, String password) {
		ResultSet rs = null;
		Connection con = MysqlConnection.getConnection();
		
		try {
			Statement stmt = con.createStatement();
			System.out.println("after connectin");
			rs = stmt.executeQuery("select Email_Address , Password from Customer where Email_Address='"+email+"' AND Password= '"+password+"')");
			System.out.println("after query");
			if(rs.next()){
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}	
}
		
