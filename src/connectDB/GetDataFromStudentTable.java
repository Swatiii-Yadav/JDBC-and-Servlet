package connectDB;

import  java.sql.*;
public class GetDataFromStudentTable {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "12345678";
        try {
            //load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            //established connection
            Connection con=DriverManager.getConnection(url,user,password);
            System.out.println("Database connected succefully");
            //create statement
            Statement stm=con.createStatement();
            ResultSet rst=stm.executeQuery("SELECT * FROM emp;");
            //process result
            while(rst.next()){
                System.out.println("User ID: " + rst.getInt("empId") + ", Name: " + rst.getString("empName")+
                        "  Salary: "+	rst.getDouble("salary"));
            }

            //close connection
            rst.close();
            stm.close();
            con.close();

        }catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("connection failed");
            e.printStackTrace();

        }
        catch (SQLException e) {
            // TODO: handle exception
            System.out.println("connection failed");
            e.printStackTrace();

        }
    }
}
