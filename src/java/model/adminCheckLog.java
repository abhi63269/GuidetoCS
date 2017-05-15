package model;

import db.databaseLog;
import dto.admindto;
import java.sql.*;

public class adminCheckLog 
{
 public boolean adminCheck(admindto adto)
 {
     String admail=adto.getAdmail();
     String adpassword=adto.getAdpassword();
     String adminmail="root";
     String adminpassword="root";
     if(admail!=null && adpassword!=null &&  !admail.trim().equals("") && !adpassword.trim().equals("")&&adpassword.equals(adminpassword)&&admail.equals(adminmail))
      {
          return true;
      }
     return false;
 }
}
