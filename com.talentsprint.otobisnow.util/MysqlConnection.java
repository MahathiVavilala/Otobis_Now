package com.talentsprint.otobisnow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private static String username = "root";
    private static String password = "@rtemis143";
    private static String URL = "jdbc:mysql://localhost:3306/OtobisNow";
    private static String driverClass = "com.mysql.jdbc.Driver";

    public MysqlConnection() {
    }

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(URL, username, password);
            if(conn == null) {
                System.out.println("not connected");
            } else {
                System.out.println("connected");
            }
        } catch (ClassNotFoundException var2) {
            var2.printStackTrace();
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

        return conn;
    }
}
