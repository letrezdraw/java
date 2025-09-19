import java.sql.*;
public class A1 {

    public static void main(String args[]) throws SQLException
    {
        
        
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/persondb","postgres","person");
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            stmt.executeUpdate("delete from person");
            stmt.executeUpdate("insert into person values(0,'rez','m',2005),(1,'aadesh','m',2005),(2,'sukii','f',2002),(3,'raj','m',1986),(4,'rani','f',1986);");
            System.out.println("\n Connceted");
            rs = stmt.executeQuery("select * from person");
            while(rs.next())
            {
                System.out.print("\n");
                System.out.print("\n PID = "+ rs.getInt(1));
                System.out.print("\n Name = "+ rs.getString(2));
                System.out.print("\n Gender = "+ rs.getString(3));
                System.out.print("\n Birth Year = "+ rs.getInt(4));
                System.out.print("\n");
            }


            stmt.close();
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}