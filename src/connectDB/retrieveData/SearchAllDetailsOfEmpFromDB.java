package connectDB.retrieveData;

import java.sql.*;
import java.util.Scanner;

public class SearchAllDetailsOfEmpFromDB {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "12345678";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter employee id for more details");
        int id=sc.nextInt();
        try {
            //load drivers
            Class.forName("com.mysql.cj.jdbc.Driver");
            //established connection
            Connection con= DriverManager.getConnection(url,user,password);
            System.out.println("Database connected succefully");
            //create statement
            String query="select * from emp where empId=?";
            PreparedStatement statement=con.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet rst=statement.executeQuery();
            //process result
            while(rst.next()){
                System.out.println("User ID: " + rst.getInt("empId") + ", Name: " + rst.getString("empName")+
                        "  Salary: "+	rst.getDouble("salary")+" department :" + rst.getString("department")+
                        " departmentNo: " + rst.getInt("departmentNo") +" commission: "+rst.getDouble("commission")+ " hireDate: " +rst.getString("hireDate"));
            }

            //close connection
            rst.close();
            statement.close();
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
