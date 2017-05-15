package model;

import db.databaseLog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class offeredCourses 
{
    int noOfCourses=0;
    ArrayList<String> courseinfo= new ArrayList<String>();
    
    public ArrayList courseCheck()
    {
     try
    {
        Connection con=databaseLog.getCon();

    Statement st=databaseLog.getStatement();
    
        String sql="select * from coursesoffered";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            //System.out.println("YEH LINE CHAL RAHI HJAI");
            noOfCourses=noOfCourses+1;
            courseinfo.add(rs.getString(1));
            courseinfo.add(rs.getString(2));
        }
    }
    catch(SQLException e)
    {
        System.out.println("Error");
    }  
     return courseinfo;
    }
    public int bus()
    {
        return noOfCourses;
    }
    
}
