package com.studentInfo;
import java.sql.*;
public class MainClassForStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students student = new Students("John Doe", "9876543210", "New York");
		Students student2 = new Students("John cena", "9986543210", "Texas");

        // Insert into database using StudentDAO
        boolean result = StudentData.insertStudent(student);
        boolean result2 = StudentData.insertStudent(student2);

        if (result) {
            System.out.println("🎉 Data Inserted Successfully!");
        } else {
            System.out.println("❌ Data Insertion Failed!");
        }
	}

}
