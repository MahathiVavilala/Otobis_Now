package com.talentsprint.otobisnow.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bus {
    private String Registrtion_no;
    private String BusType_ID;
    private int isAC;
    private String Seating_Type;
    private String Seatind_Capacity;
    
    
	public Bus(String registrtion_no, String busType_ID, int isAC, String seating_Type, String seatind_Capacity) {
		super();
		Registrtion_no = registrtion_no;
		BusType_ID = busType_ID;
		this.isAC = isAC;
		Seating_Type = seating_Type;
		Seatind_Capacity = seatind_Capacity;
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
    
	public static boolean canAddBus (String Registration_No, String BusType_ID, int isAC, String Seating_Type, int Seatind_Capacity ){
		Connection con = MysqlConnection.getConnection();
		System.out.println("Connection Established");
		java.sql.PreparedStatement ps = null;
		//ResultSet rs = null;
		try{
			//ps=con.prepareStatement("insert into Customer values(?,?,?,?,?);");
			ps=con.prepareStatement("insert into Customer values(?,?,?,?,?);");
			ps.setString(1, Registration_No);
			ps.setString(2, BusType_ID);
			ps.setInt(3, isAC);
			ps.setString(4, Seating_Type);  
			ps.setInt(5, Seatind_Capacity); 
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
