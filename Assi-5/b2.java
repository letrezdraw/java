import java.sql.*;
class B2 {
  public static void main(String[] a)throws Exception{
    try(Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","123");
        Statement s=c.createStatement()){
      s.executeUpdate("update Course set number_of_students=1000 where department='BCA Science'");
      System.out.println("Updated!");
    }
  }
}