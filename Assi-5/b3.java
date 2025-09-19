import java.sql.*;import java.util.*;
class B3{
  static Connection c;static Scanner sc=new Scanner(System.in);
  public static void main(String[] a)throws Exception{
    c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","postgres","123");
    while(true){
      System.out.print("1.Insert 2.Modify 3.Delete 4.Search 5.ViewAll 6.Exit:");
      switch(sc.nextInt()){
        case 1->exec("insert into District values('"+sc.next()+"',"+sc.nextInt()+","+sc.nextInt()+")");
        case 2->exec("update District set area="+sc.nextInt()+",population="+sc.nextInt()+" where name='"+sc.next()+"'");
        case 3->exec("delete from District where name='"+sc.next()+"'");
        case 4->show("select * from District where name='"+sc.next()+"'");
        case 5->show("select * from District");
        case 6->System.exit(0);
      }
    }
  }
  static void exec(String q)throws Exception{try(Statement s=c.createStatement()){System.out.println(s.executeUpdate(q)>0?"Done":"No change");}}
  static void show(String q)throws Exception{try(Statement s=c.createStatement();ResultSet r=s.executeQuery(q)){while(r.next())System.out.println(r.getString(1)+" "+r.getInt(2)+" "+r.getInt(3));}}
}