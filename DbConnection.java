
package hotel.management.system;

import java.sql.*;
public class DbConnection {
     Connection conn;
     Statement s;
    DbConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","root");
            s=conn.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
