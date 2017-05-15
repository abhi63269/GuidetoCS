package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DelQues", urlPatterns = {"/DelQues"})
public class DelQues extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sub = request.getParameter("sub");
        int qid = Integer.parseInt(request.getParameter("qid"));
        Connection con = null;
        Statement st = null;
        String query = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
            
            st = con.createStatement();
            
            query = "delete from "+sub+" where Q_id = "+qid;
            
            int i = st.executeUpdate(query);
            if(i>0)
            {
                System.out.println(i + "Records Affected");
            }
            else
            {
                System.out.println("Record Not deleted");
            }
            con.close();
        } catch (Exception e) 
        {
            System.out.println(e);
        } 
       response.sendRedirect("delQues.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
