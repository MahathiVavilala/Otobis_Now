package com.talentsprint.otobisnow.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bus {
    private String busNo;
    private Integer Capacity;
    private String isAvailable;
    private Integer busTypeId;
    private Integer busCategoryId;
    private Integer busDepoId;
    private String busDepo;
    private String busType;
    private String busCategory;

    public Bus() {
    }

    public Integer getBusTypeId() {
        return this.busTypeId;
    }

    public String getBusDepo() {
        return this.busDepo;
    }

    public void setBusDepo(String busDepo) {
        this.busDepo = busDepo;
    }

    public String getBusType() {
        return this.busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getBusCategory() {
        return this.busCategory;
    }

    public void setBusCategory(String busCategory) {
        this.busCategory = busCategory;
    }

    public void setBusTypeId(Integer busTypeId) {
        this.busTypeId = busTypeId;
    }

    public Integer getBusCategoryId() {
        return this.busCategoryId;
    }

    public void setBusCategoryId(Integer busCategoryId) {
        this.busCategoryId = busCategoryId;
    }

    public Integer getBusDepoId() {
        return this.busDepoId;
    }

    public void setBusDepoId(Integer busDepoId) {
        this.busDepoId = busDepoId;
    }

    public String getBusNo() {
        return this.busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public Integer getCapacity() {
        return this.Capacity;
    }

    public void setCapacity(Integer capacity) {
        this.Capacity = capacity;
    }

    public String getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
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
