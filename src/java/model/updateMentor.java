package model;

import db.updateAccountDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class updateMentor 
{
    public void updationMentor(ArrayList<String>updateMentor,String mentorcourseid)
    {
        int i=0;
        Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        while(i<updateMentor.size())
        {
              try
        {
            String sql="insert into mentordetails values(?,?)";
            pst=con.prepareStatement(sql);
            pst.setString(1,mentorcourseid);
            pst.setString(2,updateMentor.get(i));
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
        i=i+1;
    }
}
    public void  delMentor(String delmentor)
    {
       Connection con=updateAccountDatabase.getCon();
        PreparedStatement pst=updateAccountDatabase.getSt();
        try
        {
            String sql="delete from mentordetails where MentorMail=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,delmentor);
            int j=pst.executeUpdate();
            if(j>0)
            {
                System.out.println(j+" Record Deleted From Videos");
               
            }
            else
            {
                System.out.println("Record Not Deleted From Videos");
           
            } 
    }
         catch(SQLException e)
        {
            System.out.println("eror"+e);
        }
}
}
