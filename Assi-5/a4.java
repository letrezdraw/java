import java.sql.*;
import java.util.Scanner;

public class a4 {
    public static void main(String[] a) {
        try (Scanner s = new Scanner(System.in);
             Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/person", "postgres", "person");
             PreparedStatement ps = c.prepareStatement("INSERT INTO employee(id, name, salary) VALUES (?, ?, ?)")) {

            Class.forName("org.postgresql.Driver");

            System.out.println("Enter number of employees to insert:");
            int n = Integer.parseInt(s.nextLine());

            for (int i = 1; i <= n; i++) {
                System.out.println("Enter details for employee " + i);

                System.out.print("ID: ");
                ps.setInt(1, Integer.parseInt(s.nextLine()));

                System.out.print("Name: ");
                String name = s.nextLine();
                ps.setString(2, name);

                System.out.print("Salary: ");
                ps.setFloat(3, Float.parseFloat(s.nextLine()));

                System.out.println(ps.executeUpdate() > 0 ?
                    "Employee " + name + " inserted successfully." :
                    "Insertion failed for employee " + name);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
