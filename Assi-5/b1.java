import java.sql.*;
import java.util.Scanner;

public class b1 {
    public static void main(String[] a) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found.");return;
        }

        try (Scanner s = new Scanner(System.in);
             Connection c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/persondb", "postgres", "person");
             Statement st = c.createStatement()) {

            System.out.println("\nConnected");
            String q;int ch;

            do {
                System.out.println("----- Menu -----\n1. Display all from 1986\n2. Display all from 2000-2005\n3. Exit");
                System.out.print("Enter your choice: ");

                ch = s.nextInt();s.nextLine();

                switch (ch) {
                    case 1: q = "SELECT * FROM person WHERE birth_year = 1986";break;
                    case 2: q = "SELECT * FROM person WHERE birth_year BETWEEN 2000 AND 2005";break;
                    case 3: System.out.println("Exiting");return;
                    default: System.out.println("Invalid choice. Please try again.");continue;
                }

                try (ResultSet rs = st.executeQuery(q)) {
                    while (rs.next()) {
                        System.out.printf("\nPID = %d\nName = %s\nGender = %s\nBirth Year = %d\n",
                                rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    }
                }
                System.out.println();
            } while (true);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
