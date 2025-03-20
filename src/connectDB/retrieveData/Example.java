package connectDB.retrieveData;

import java.sql.*;

public class Example {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //difine the url ,user and password
        String url="jdbc:mysql://localhost:3306/student";
        String user="root";
        String password="12345678";

        try
        {
            //1. load the drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. established the conenction
            Connection con= DriverManager.getConnection(url,user,password);
            System.out.println("connection  established");

            //3. create statement
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery("SELECT * FROM  empdetails");


            //4. execute queries
            while(res.next()) {
                System.out.println("User ID: " + res.getInt("empId") + ", Name: " + res.getString("empName"));
            }

        }catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("connection failed");
            e.printStackTrace();

        }catch (SQLException e) {
            // TODO: handle exception
            System.out.println("connection failed");
            e.printStackTrace();

        }
    }

}
