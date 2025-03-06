package com.studentInfo;
import java.sql.*;

public class ConnectionProvider {
	
	 static Connection conn;

	public static Connection createConnection() {
		  try {
	 String url = "jdbc:mysql://localhost:3306/student_manage";
     String user = "root";
     String password = "12345678";

     conn = DriverManager.getConnection(url, user, password);
         if (conn != null) {
             System.out.println("Connection successful!");
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return conn;
	}
    
}
