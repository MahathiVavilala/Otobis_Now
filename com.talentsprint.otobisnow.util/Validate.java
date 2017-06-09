package com.talentsprint.otobisnow.util;

import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql:/ /localhost:3306/OtobisNow","root","@rtemis143");
         PreparedStatement ps =con.prepareStatement
                             ("select Email_Address, password from login1 where Email_Address=? and password=?");
         //ps.setString(1, email);
         //ps.setString(2, pass);
         ResultSet rs = ps.executeQuery();
         
         //System.out.println(rs.getMetaData());
         //st = rs.next();
         return rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
	return true;
                          
  }   
}
