package connectDB.retrieveData;

import java.sql.*;
import java.util.Scanner;

public class SearchForEmpName {

    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "12345678";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  name for more details");
        String name = sc.nextLine();
        try {
            //load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            //established connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected succefully");
            //create statement
            String query = "select * from emp where empName=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, name);
            ResultSet rst = statement.executeQuery();
            //process result
            while (rst.next()) {
                System.out.println("User ID: " + rst.getInt("empId") + ", Name: " + rst.getString("empName"));
            }

            //close connection
            rst.close();
            statement.close();
            con.close();

        } catch (ClassNotFoundException e) {

            System.out.println("connection failed");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("connection failed");
            e.printStackTrace();

        }
    }

}