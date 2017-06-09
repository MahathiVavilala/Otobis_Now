package com.talentsprint.otobisnow.dao;


import java.sql.SQLException;

import com.talentsprint.otobisnow.util.MysqlConnection;

import java.sql.*;



public class AdminDAO {
	Connection connection =MysqlConnection.getConnection();
	ResultSet resultSet = null;
	public boolean isAdmin(String uname,String pass) {
		
	try {
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from Admin where username = '"+uname+"' AND password = '"+ pass+"'" );
		if(resultSet.next()) 
			return true;
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return false;
	}

}
