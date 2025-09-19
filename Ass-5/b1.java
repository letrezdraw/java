import java.sql.*;
import java.util.Scanner;

public class b1 {
    public static void main(String args[]) throws SQLException
    {
        
        
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/persondb","postgres","person");
            Statement stmt = con.createStatement();
            ResultSet rs1 = null;
            ResultSet rs2 = null;
            System.out.println("\n Connceted");
            Scanner scanner = new Scanner(System.in);
            int ch;
            do 
            {
                    System.out.println("----- Menu -----");
                    System.out.println("1. Display all from 1986");
                    System.out.println("2. Display all from 2000-2005");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");

                    ch = scanner.nextInt();

                    switch (ch) 
                        {
                            case 1:
                                rs1 = stmt.executeQuery("select * from person where person.brith_year = 1986;");
                                while(rs1.next())
                                {
                                    System.out.print("\n");
                                    System.out.print("\n PID = "+ rs1.getInt(1));
                                    System.out.print("\n Name = "+ rs1.getString(2));
                                    System.out.print("\n Gender = "+ rs1.getString(3));
                                    System.out.print("\n Birth Year = "+ rs1.getInt(4));
                                    System.out.print("\n");
                                }
                                break;
                            case 2:
                                rs2 = stmt.executeQuery("select * from person where person.brith_year >= 2000 and person.brith_year <=2005;");
                                while(rs2.next())
                                {
                                    System.out.print("\n");
                                    System.out.print("\n PID = "+ rs2.getInt(1));
                                    System.out.print("\n Name = "+ rs2.getString(2));
                                    System.out.print("\n Gender = "+ rs2.getString(3));
                                    System.out.print("\n Birth Year = "+ rs2.getInt(4));
                                    System.out.print("\n");
                                }
                                break;
                            case 3:
                                System.out.println("Exiting");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    System.out.println();

            } while (ch != 3);
            scanner.close();
            stmt.close();
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
