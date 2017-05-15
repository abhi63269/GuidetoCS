package model;

import db.databaseLog;
import db.updateAccountDatabase;
import java.sql.*;
import java.util.ArrayList;

public class existingCourses 
{
    int countEnrollCourse=0;
    ArrayList<String> enrolledCourseID=new ArrayList<String>();
    public ArrayList fetchCourses(String umail)
    {
        String uMail=umail;
        Connection con = databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="select * from existingCourses where Mail='"+uMail+"'";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                countEnrollCourse=countEnrollCourse+1;
                enrolledCourseID.add(rs.getString(2));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error!");
        }
        return enrolledCourseID;
    }
    public boolean checkCourses(String proid,String umail)
    {
        String checkid=proid;
        String checkmail=umail;
        Connection con = databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            String sql="select CourseID from existingcourses where Mail='"+checkmail+"'and CourseID='"+checkid+"'";
            ResultSet rs=st.executeQuery(sql);
            if(!rs.next())
            {
                String sql1="insert into existingcourses values(?,?)";
                pst=con.prepareStatement(sql1);
                pst.setString(1,checkmail);
                pst.setString(2,checkid);
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
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
        return false;
    }
    public int retcount()
    {
        return countEnrollCourse;
    }
}
