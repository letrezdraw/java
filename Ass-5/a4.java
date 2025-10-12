import java.sql.*;
import java.util.Scanner;

public class a4{
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/person","postgres","person");
			String sql = "INSERT INTO employee(id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);

            System.out.println("Enter number of employees to insert:");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("Enter details for employee " + (i + 1));

                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Salary: ");
                float salary = Float.parseFloat(scanner.nextLine());

                pstmt.setInt(1, id);
                pstmt.setString(2, name);
                pstmt.setFloat(3, salary);

                int rows = pstmt.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee " + name + " inserted successfully.");
                } else {
                    System.out.println("Insertion failed for employee " + name);
                }
            }

            pstmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
