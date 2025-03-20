package connectDB.march18;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class UpdateStudent {


        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/student";
            String user = "root";
            String password = "12345678";

            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter  iD to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter  Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter New Email: ");
            String newEmail = scanner.nextLine();


            String updateQuery = "UPDATE StudentDetails SET name = ?, email = ? WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {


                pstmt.setString(1, newName);
                pstmt.setString(2, newEmail);
                pstmt.setInt(3, id);


                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println(" updated successfully!");
                } else {
                    System.out.println(" ID not found. No record updated.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                scanner.close();
            }
        }
    }

