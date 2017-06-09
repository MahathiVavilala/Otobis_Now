package com.talentsprint.otobisnow.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.talentsprint.otobisnow.util.MysqlConnection;

public class BusBean {
	
	    private String Registrtion_no;
	    private String BusType_ID;
	    private int isAC;
	    private String Seating_Type;
	    private String Seatind_Capacity;
	    
	    
		public BusBean(){
		}


		public String getRegistrtion_no() {
			return Registrtion_no;
		}


		public void setRegistrtion_no(String registrtion_no) {
			Registrtion_no = registrtion_no;
		}


		public String getBusType_ID() {
			return BusType_ID;
		}


		public void setBusType_ID(String busType_ID) {
			BusType_ID = busType_ID;
		}


		public int getIsAC() {
			return isAC;
		}


		public void setIsAC(int isAC) {
			this.isAC = isAC;
		}


		public String getSeating_Type() {
			return Seating_Type;
		}


		public void setSeating_Type(String seating_Type) {
			Seating_Type = seating_Type;
		}


		public String getSeatind_Capacity() {
			return Seatind_Capacity;
		}


		public void setSeatind_Capacity(String seatind_Capacity) {
			Seatind_Capacity = seatind_Capacity;
		}
    public static boolean isBus(String src, String dest) {
		System.out.println(src);
		System.out.println(dest);
		Connection con = MysqlConnection.getConnection();
		Statement ps = null;
		ResultSet rs = null;
		try {

			ps = con.createStatement();
			rs = ps.executeQuery("select * from Bus B, BusType BT where B.BusType_ID = BT.BusType_ID and  Registration_No in (select Registration_No from Schedule S, Route R where S.Route_ID = R.Route_ID and R.Source = '"+src+"' and R.Destination = '"+dest+"');");
			//int i = 0;
			while (rs.next()) {
				System.out.println(rs.getString(1));
				//i++;
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}