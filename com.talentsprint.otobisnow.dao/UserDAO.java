package com.talentsprint.otobisnow.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.talentsprint.otobisnow.bean.UserBean;
import com.talentsprint.otobisnow.util.MysqlConnection;
import com.talentsprint.otobisnow.util.ValidateUtils;

public class UserDAO {
	private  Connection conn; 
	private  PreparedStatement pstmt;
	private  ResultSet rs;
	private  ArrayList<UserBean> listOfUserBeans;

public  ArrayList<UserBean> getRegularUserList()
	{
		listOfUserBeans=new ArrayList<UserBean>();
	conn=MysqlConnection.getConnection();	
		UserBean userBeanObj=null;
		try {	
				pstmt=conn.prepareStatement("select * from Customer"
					);
			 rs=pstmt.executeQuery();
			 while (rs.next()) {
				 userBeanObj=new UserBean();
					userBeanObj.setUserId(rs.getInt("user_id"));
					userBeanObj.setFirstName(rs.getString("first_name"));
					userBeanObj.setLastName(rs.getString("last_name"));
				    userBeanObj.setMobile(rs.getString("mobile_no"));
				    userBeanObj.setEmail(rs.getString("email"));
				    listOfUserBeans.add(userBeanObj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return listOfUserBeans;
	}



	public Object checkUser(String userName,String password)
	{
		UserBean userBeanObj=null;
		//AdminBean adminBeanObj=null;
		try {
			
			conn=MysqlConnection.getConnection();
			pstmt=conn.prepareStatement("select * from Customer where Email_Address=?");
			pstmt.setString(1, userName);
			rs=pstmt.executeQuery();
			 if(rs.next() && ValidateUtils.base64decode(rs.getString("password")).equals(password) )
			 {
				 userBeanObj=new UserBean();
					  userBeanObj.setPassword(ValidateUtils.base64decode(rs.getString("password")));
					 userBeanObj.setUserId(rs.getInt("user_id"));
					userBeanObj.setFirstName(rs.getString("first_name"));
					userBeanObj.setLastName(rs.getString("last_name"));
				    userBeanObj.setMobile(rs.getString("mobile_no"));
				    userBeanObj.setEmail(rs.getString("email"));
				  
				    return userBeanObj;
			 }
			 else
			 {	 
				
					    return null;
				 }
				 
			 
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return null;

	}


	
public boolean isEmailExists(String email)
{
	   conn=com.talentsprint.otobisnow.util.MysqlConnection.getConnection();
			try {
				pstmt=conn.prepareStatement("select * from customer where Email_Address=?");
				pstmt.setString(1, email);
				rs=pstmt.executeQuery();
				 if (rs.next()) {
			return true;
				 }
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return false;
}
}
