package model;

import db.databaseLog;
import db.updateAccountDatabase;
import dto.userinfodto;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class userRegister 
{
    public boolean registerUser(userinfodto uid) throws SQLException
    {
        InputStream inputStream = null;
        inputStream=uid.getInputStream();
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            String sql="insert into registerdb values(?,?,?,?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,uid.getUname());
            pst.setString(2,uid.getUbranch());
            pst.setString(3,uid.getUsem());
            pst.setString(4,uid.getUgen());
            pst.setString(5,uid.getUmail());
            pst.setString(6,uid.getUphone());
            pst.setString(7,uid.getUpass() );
            System.out.println("inputStream"+inputStream);
            if (inputStream != null) {
                //files are treated as BLOB objects in database
                //here we're letting the JDBC driver
                //create a blob object based on the
                //input stream that contains the data of the file
                System.out.println("yeh chalakakaka");
                pst.setBlob(8,inputStream);
                System.out.println("shdssjksdj");
            }
            System.out.println("hjfjdlfjdfklja");
            int i = pst.executeUpdate();
            System.out.println("i"+i);
            if(i>0)
            {
                System.out.println(i+" Record Updated");
                return true;
            }
            else
            {
                System.out.println("Record Not Updated");
                return false;
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error!"+e);
        }
      
     return false;   
    }
    
}
