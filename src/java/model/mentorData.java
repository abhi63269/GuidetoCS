package model;

import db.databaseLog;
import java.sql.*;
import java.util.ArrayList;

public class mentorData 
{
    int count=0;
    ArrayList<String>dataMentor=new ArrayList<String>();
    public ArrayList getMentorDetail()
    {
        count=0;
        Connection con=databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="select MentorMail from mentordetails";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                count++;
                dataMentor.add(rs.getString(1));
            }
        
        }
        catch(SQLException e)
        {
            System.out.println("error"+e);
        }
        return dataMentor;
    }
    
}
