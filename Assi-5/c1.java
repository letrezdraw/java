import java.sql.*;import javax.swing.*;import java.awt.*;
class C1{
  public static void main(String[]a)throws Exception{
    Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","123");
    c.createStatement().execute("create table if not exists Student(roll int,name varchar,per float)");
    c.createStatement().execute("insert into Student values(1,'Rez',88.5),(2,'Alex',92.0)");
    ResultSet r=c.createStatement().executeQuery("select * from Student");
    r.last();int rows=r.getRow();r.beforeFirst();
    String[][]d=new String[rows][3];int i=0;
    while(r.next())d[i++]=new String[]{r.getString(1),r.getString(2),r.getString(3)};
    JFrame f=new JFrame("Students");f.add(new JScrollPane(new JTable(d,new String[]{"Roll","Name","Per"})),BorderLayout.CENTER);
    f.setSize(300,200);f.setVisible(true);f.setDefaultCloseOperation(3);
  }
}