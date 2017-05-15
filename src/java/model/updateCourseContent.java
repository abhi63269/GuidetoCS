package model;

import db.updateAccountDatabase;
import java.sql.*;
import java.util.ArrayList;

public class updateCourseContent 
{
    public boolean updateVideoCourse(ArrayList<String>updateVideoContent,String courseid)
    {
        int i=0,k=1;
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        while(i<updateVideoContent.size()&&k<updateVideoContent.size())
        {
        try
        {
            String sql="insert into videos values(?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,courseid);
            pst.setString(2,updateVideoContent.get(i));
            pst.setString(3,updateVideoContent.get(k));
            int j=pst.executeUpdate();
            if(j>0)
            {
                System.out.println(j+" Record Updated");
               
            }
            else
            {
                System.out.println("Record Not Updated");
           
            }
        }
        catch(SQLException e)
        {
            System.out.println("eror"+e);
        }
        i=i+2;
        k=k+2;
        
        }
        return true;
    }
    public boolean updateBookCourse(ArrayList<String>updateBookContent,String courseid)
    {
        int i=0,k=1;
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        while(i<updateBookContent.size()&&k<updateBookContent.size())
        {
        try
        {
            String sql="insert into books values(?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,courseid);
            pst.setString(2,updateBookContent.get(i));
            pst.setString(3,updateBookContent.get(k));
            int j=pst.executeUpdate();
            if(j>0)
            {
                System.out.println(j+" Record Updated");
               
            }
            else
            {
                System.out.println("Record Not Updated");
           
            }
        }
        catch(SQLException e)
        {
            System.out.println("eror"+e);
        }
        i=i+2;
        k=k+2;
        
        }
        
        return true;
    }
     public void updateCourseOffered(String cid,String coursename,String coursedesc)
    {
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            String sql="insert into coursesoffered values(?,?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,cid);
            pst.setString(2,coursename);
            pst.setString(3, coursedesc);
            int j=pst.executeUpdate();
            if(j>0)
            {
                System.out.println(j+" Record Updated");
               
            }
            else
            {
                System.out.println("Record Not Updated");
           
            }
        }
        catch(SQLException e)
        {
            System.out.println("eror"+e);
        }
    }
    public void deleteCourse(String cid)
    {
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            String sql="delete from videos where CID=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,cid);
            int j=pst.executeUpdate();
            if(j>0)
            {
                System.out.println(j+" Record Deleted From Videos");
               
            }
            else
            {
                System.out.println("Record Not Deleted From Videos");
           
            }
            String sql1="delete from books where CID=?";
            pst=con.prepareStatement(sql1);
            pst.setString(1,cid);
            int h=pst.executeUpdate();
            if(h>0)
            {
                System.out.println(h+" Record Deleted From Books");
               
            }
            else
            {
                System.out.println("Record Not Deleted From Books");
           
            }
            String sql2="delete from coursesoffered where CourseID=?";
            pst=con.prepareStatement(sql2);
            pst.setString(1,cid);
            int op=pst.executeUpdate();
            if(op>0)
            {
                System.out.println(op+" Record Deleted From COursesOffered");
               
            }
            else
            {
                System.out.println("Record Not Deleted From COursesOffered");
           
            }
        }
        
        catch(SQLException e)
        {
            System.out.println("eror"+e);
        }
    }
   
}
