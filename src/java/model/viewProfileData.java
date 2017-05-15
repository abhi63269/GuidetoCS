package model;

import db.databaseLog;
import java.sql.*;
import java.util.ArrayList;

public class viewProfileData 
{ 
    
    int noOfUserEnroll=0;
    String viewMail="",viewDept="";

    public String getViewMail() {
        return viewMail;
    }

    public void setViewMail(String viewMail) {
        this.viewMail = viewMail;
    }

    public String getViewDept() {
        return viewDept;
    }

    public void setViewDept(String viewDept) {
        this.viewDept = viewDept;
    }
    public ArrayList viewData(String viewData)
    {
        ArrayList<String> viewInfo=new ArrayList<String>();
        noOfUserEnroll=0;
        Connection con=databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="SELECT Branch,coursesoffered.CourseName FROM coursesoffered,existingcourses,registerdb WHERE registerdb.Name='"+viewData+"' AND registerdb.Mail=existingcourses.Mail  AND existingcourses.CourseID=coursesoffered.CourseID";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                noOfUserEnroll++;
                viewDept=rs.getString(1);
                viewInfo.add(rs.getString(2));
                
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
        return viewInfo;
    }
    public String getMail(String viewName)
    {
          Connection con=databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="SELECT Mail FROM registerdb WHERE registerdb.Name='"+viewName+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                viewMail=rs.getString(1);
              
                
            }
            
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
        return viewMail;
    }
    public int yeol()
    {
        return noOfUserEnroll;
    }
}
