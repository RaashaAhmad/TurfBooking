
import java.sql.*;

public interface Booking {
    static void viewPrice(String sport)
    {
       try
       {
           String query;
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/turfbookingsystem", "root", "password");
           Statement stmt=con.createStatement();
           sport=sport.substring(0,1).toUpperCase()+sport.substring(1);
           query="select * from slots where sportname=\""+sport+"\";";
           ResultSet rs=stmt.executeQuery(query);
           System.out.println("Slot No.\tStart Time \tEnd Time \tPrice");
           while(rs.next())
           {
            System.out.println(" "+rs.getInt(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getFloat(4));
           }
           con.close();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
}
