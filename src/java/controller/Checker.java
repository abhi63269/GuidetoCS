package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Checker", urlPatterns = {"/Checker"})
public class Checker extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        ArrayList <String> qans = new ArrayList<String>();
        int count = 0,i,high=0,j=0,h=0;
        double result;
        HttpSession session = request.getSession(true);
        String umail = (String) session.getAttribute("umail");
        String sub = (String) session.getAttribute("sub");
        high += (Integer)session.getAttribute("size");
        h = high;
        ArrayList<String> ans = (ArrayList<String>)session.getAttribute("ans");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Loaded");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
            
            
            String query1 = "select Cktans,Attque from progressdetails where Mail=?;";
            pst = con.prepareStatement(query1);
            pst.setString(1,umail);
            rs =  pst.executeQuery();
            
            while(rs.next())
            {
                count += Integer.parseInt(rs.getString(1));
                high += Integer.parseInt(rs.getString(2));
            }
            j = count;
            String query = "select * from "+sub+";";
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                System.out.println(rs.getString(7));
                qans.add(rs.getString(7));
            }
            con.close();
        }catch (Exception e) 
        {
            System.out.println(e);
        }
        
        for(i=0;i<qans.size();i++)
        {
            if(qans.get(i).equals(ans.get(i)))
            {
                count++;
            }
        }
        
        result = (count*100)/high;
        j = count - j;
        session.setAttribute("maxque", h);
        session.setAttribute("cktque", j);
        //String res = result+"\0";
        //System.out.println(res);
        session.setAttribute("result", result);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Loaded");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");
            
            String aquery = "update progressdetails set Cktans="+count+",Attque="+high+" where Mail=?;";
            pst = con.prepareStatement(aquery);
            pst.setString(1,umail);
            i = pst.executeUpdate();
            if(i>0)
            {
                System.out.println(i+"Records Affected");
            }
        }catch (Exception e) 
        {
            System.out.println(e);
        }
        session.removeAttribute("list");
        response.sendRedirect("result.jsp");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
