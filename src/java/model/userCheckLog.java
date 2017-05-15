package model;

import db.databaseLog;
import dto.userLogClass;
import dto.userinfodto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userCheckLog 
{

    userinfodto uid=new userinfodto();
    String name="";
  public boolean userCheck(userLogClass ulc)
  {
      
      String pass="";
      String umail=ulc.getUmail();
      String upass=ulc.getUpass();
      Connection con=databaseLog.getCon();
      Statement st=databaseLog.getStatement();
      try
      {
          String sql="select * from registerdb where Mail='"+umail+"'";
          ResultSet rs=st.executeQuery(sql);
          if(rs.next())
          {
              name=rs.getString(1);
              uid.setUbranch(rs.getString(2));
              uid.setUsem(rs.getString(3));
              uid.setUgen(rs.getString(4));
              uid.setUphone(rs.getString(6));
              pass=rs.getString(7);
              uid.setUpass(pass);
          }
          else
          {
              return false;
          }
          
      }
      catch(SQLException e)
        {
            System.out.println("Error" +e);
        }
      if(umail!=null && upass!=null &&  !umail.trim().equals("") && !upass.trim().equals("")&&pass.equals(upass))
      {
          return true;
      }
      return false;
  }
  public String giveBack()
  {
      return name;
  }
   public userinfodto getUid() 
   {
        return uid;
    }
   
}
