package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class updateAccountDatabase 
{
   private static Connection con=null;
    private  static PreparedStatement st=null;

    public static PreparedStatement getSt() {
        return st;
    }

    public static void setSt(PreparedStatement st) {
        updateAccountDatabase.st = st;
    }
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
        }
        catch(SQLException e)
        {
            System.out.println("Error" +e);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    public static Connection getCon() {
        
        return con;
    }
  
}
