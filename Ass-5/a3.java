import java.sql.*;

public class a3{
	public static void main(String args[]){
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/persondb","postgres","person");
			Statement stmt = con.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery("select * from country where region='West'");
			while(rs.next()){
				System.out.print("Name = "+rs.getString(1));
				System.out.println("Continent = "+rs.getString(2));
				System.out.println("Capital = "+rs.getString(3));
				System.out.println("Region = "+rs.getString(4));
			}
			stmt.close();
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}
}
