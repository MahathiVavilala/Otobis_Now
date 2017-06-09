package com.talentsprint.otobisnow.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class User {

	private String firstName;
	private String lastName;
	private String password;
	private String mobile;
	private String email;

	public User() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean isUser(String email, String pass) {
		System.out.println(email);
		System.out.println(pass);
		Connection con = MysqlConnection.getConnection();
		Statement ps = null;
		ResultSet rs = null;
		try {

			ps = con.createStatement();
			rs = ps.executeQuery(
					"select * from Customer where Email_Address = '"+email+"' and Password = MD5('"+pass+"')");
			//int i = 0;
			if (rs.next()) {
				System.out.println(rs.getString(1));
				//i++;
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean canAddUser (String email, String firstName, String lastName, String password, String mobileNumber ){
		Connection con = MysqlConnection.getConnection();
		System.out.println("Connection Established");
		java.sql.PreparedStatement ps = null;
		//ResultSet rs = null;
		try{
			//ps=con.prepareStatement("insert into Customer values(?,?,?,?,?);");
			ps=con.prepareStatement("insert into Customer values(?,?,?,?,md5(?));");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, mobileNumber);
			ps.setString(4, email);  
			ps.setString(5, password); 
			if(ps.executeUpdate() > 0){
				System.out.println("Iffff");
				return true;
				
			}
			System.out.println("Not if");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}
}
