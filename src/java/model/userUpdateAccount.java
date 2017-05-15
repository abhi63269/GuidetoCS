package model;

import db.updateAccountDatabase;
import dto.userupdatedto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userUpdateAccount 
{
    public boolean edit(userupdatedto uudto)
    {
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            pst=con.prepareStatement("update registerdb set Password=? where Mail=?");
            if(uudto.getNpass()!=null && uudto.getCpass()!=null&& !uudto.getNpass().trim().equals("")&& !uudto.getCpass().trim().equals("") && uudto.getNpass().equals(uudto.getCpass()))
            {
                pst.setString(1, uudto.getNpass());
            }
            pst.setString(2, uudto.getUmail());
             int i = pst.executeUpdate();

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
        catch (SQLException e) 
        {
            System.out.println(e);
        }
           return false;
    }
}
