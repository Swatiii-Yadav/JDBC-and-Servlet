package connectDB.march18;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertMultipleTable {


        public static void main(String[] args) {
            String URL = "jdbc:mysql://localhost:3306/student";
            String USER = "root";
            String PASSWORD = "12345678";
            Scanner scanner = new Scanner(System.in);


            String insertQuery = "INSERT INTO StudentDetails (id, name, email) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

                System.out.print("How many student doyou want to insert");
                int n = scanner.nextInt();
                scanner.nextLine();

                for (int i = 1; i <= n; i++) {
                    System.out.println("Enter details for User " + i + ":");
                    System.out.print("Enter User ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, email);

                    pstmt.executeUpdate();
                    System.out.println("User " + i + "inserted successfully");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                scanner.close();
            }

            System.out.println("All student inserted successfully!");
        }
    }


