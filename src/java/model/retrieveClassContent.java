package model;

import db.databaseLog;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class retrieveClassContent 
{
    int noOfVideos=0,noOfBooks=0;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }
    String courseName="",courseDesc="";
    ArrayList<String> videoContent=new ArrayList<String>();
    ArrayList<String> bookContent=new ArrayList<String>();
    public ArrayList getClassContent(String proid)
    {
        String CourseID=proid;
        Connection con=databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="select Link,Name from videos where CID='"+CourseID+"'";
            
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                noOfVideos++;
                videoContent.add(rs.getString(1));
                videoContent.add(rs.getString(2));
            }
            
            String sql1="select Link,Name from books where CID='"+CourseID+"'"; 
            ResultSet rs1=st.executeQuery(sql1);
            while(rs1.next())
            {
                noOfBooks++;
                bookContent.add(rs1.getString(1));
                bookContent.add(rs1.getString(2));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
        
        
        return videoContent;
    }

    public int getNoOfVideos() {
        return noOfVideos;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }
    public ArrayList giveback()
    {
        return bookContent;
    }
    public void getInfoTech(String proid)
    {
        Connection con=databaseLog.getCon();
        Statement st=databaseLog.getStatement();
        try
        {
            String sql="select CourseName,Description from coursesoffered where CourseID='"+proid+"'";
            ResultSet rs= st.executeQuery(sql);
            if(rs.next())
            {
                courseName=rs.getString(1);
                courseDesc=rs.getString(2);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error"+e);
        }
    }
}
