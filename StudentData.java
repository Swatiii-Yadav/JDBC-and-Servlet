package com.studentInfo;
import java.sql.*;
public class StudentData {
	public static boolean insertStudent(Students student) {
		boolean success = false;
        Connection conn = ConnectionProvider.createConnection();
        if (conn==null) {
			System.out.println("Connection Failed");
			return false;
		}
        
        try {
            // SQL Query
            String query = "INSERT INTO StudentDataBase (sname, phone, city) VALUES (?, ?, ?)";
            
            // Prepare Statement
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, student.getStudentName());
            p.setString(2, student.getStudentPhone());
            p.setString(3, student.getCity());
            
            // Execute Update
            int rowsAffected = p.executeUpdate();
            
            if (rowsAffected > 0) {
                success = true;
                System.out.println("✅ Student inserted successfully!");
            }

            // close resources
            p.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
	}
}
