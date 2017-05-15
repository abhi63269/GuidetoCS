package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseLog 
{
    private static Connection con=null;
    private  static Statement st=null;
    static
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
            st=con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("Error" +e);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(databaseLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Statement getStatement() {
        return st;
    }


    public static Connection getCon() {
        
        return con;
    }


    
    
    
}
