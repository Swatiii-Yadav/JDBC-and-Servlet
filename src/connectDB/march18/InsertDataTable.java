package connectDB.march18;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class InsertDataTable {

        public static void main(String[] args) {

            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "12345678";

            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();


            String insertQuery = "INSERT INTO StudentDetails (id, name, email) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {


                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setString(3, email);

                int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("student  inserted successfully!");
                } else {
                    System.out.println("Fail .");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                scanner.close();
            }
        }
    }


