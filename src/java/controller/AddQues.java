package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddQues", urlPatterns = {"/AddQues"})
public class AddQues extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("GET method");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sub = request.getParameter("sub");
        String q = request.getParameter("ques");
        String a = request.getParameter("opt1");
        String b = request.getParameter("opt2");
        String c = request.getParameter("opt3");
        String d = request.getParameter("opt4");
        String ans = request.getParameter("ans");
        int count=0;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
            
            st = con.createStatement();
            
            String query1 = "select * from " + sub + ";";
            
            rs = st.executeQuery(query1);
            while(rs.next())
            {
                count++;
            }
            pst = con.prepareStatement("Insert into "+sub+" values(?,?,?,?,?,?,?)");

            pst.setInt(1, (count+1));
            pst.setString(2, q);
            pst.setString(3, a);
            pst.setString(4, b);
            pst.setString(5, c);
            pst.setString(6, d);
            pst.setString(7, ans);
            //String query = "Insert into emp values(100,'Ram','987654')";
            //String query = "Insert into emp values("+id+",'"+name+"','"+password+"')";
            //String query = "Insert into "+sub+" values("+count+",'"+q+"','"+a+"','"+b+"','"+c+"','"+d+"','"+ans+"');";
            
            int i = pst.executeUpdate();

            if(i>0)
            {
                System.out.println(i+" Record Inserted"); 
            }
            else
            {
                System.out.println("Record Not Inserted");
            }
            con.close();
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println(e);
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
