package model;

import db.databaseLog;
import java.sql.*;

public class showChart 
{
  
    public int getCount(String courseID)
    {
            int count =0;
        Connection con= databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="SELECT Mail FROM coursesoffered,existingcourses WHERE coursesoffered.CourseID='"+courseID+"' and existingcourses.CourseID='"+courseID+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                count++;
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
       
        return count;
    
    }
}
