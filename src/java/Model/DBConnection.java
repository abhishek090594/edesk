package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection con = null;

    public Connection Connection()
    {
          try
            {
               
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/erd","root","");
          
            }
            catch(Exception e)
            {
                System.out.println("Errror"+e);
           }
               return con;
  
    }
}
