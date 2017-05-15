package controller;
import model.DataQuiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet(name = "QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
    int k=0,max=0;
    DataQuiz data = null;
    ArrayList<DataQuiz> list = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String proid = (String) session.getAttribute("proid");
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String sub = null;
        list = new ArrayList<DataQuiz>();
        String umail = (String) session.getAttribute("umail");
        try
        {
            System.out.println(proid);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class Loaded");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/guidetocs","root","root");
            System.out.println("Connected");

            String query3 = "select * from progressdetails where Mail= ? ;";
         
            pst = con.prepareStatement(query3);
            pst.setString(1,umail);
            rs = pst.executeQuery();
            
            if(rs.next())
            { System.out.println("sdfgsgh");
            }
            else
            {
            pst = con.prepareStatement("Insert into progressdetails values(?,?,?)");
            pst.setString(1,umail);
            pst.setInt(2,0);
            pst.setInt(3,0);
            int i = pst.executeUpdate();
            }
            String query1 = "select tablename from subquestion where C_id = " + proid + ";";
            st = con.createStatement();
            rs = st.executeQuery(query1);
            rs.next();
            System.out.println(rs.getString(1));
            sub = rs.getString(1);
            String query = "select * from "+sub+";";
            
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                data = new DataQuiz();
                data.setques(rs.getString(2));
                data.setop1(rs.getString(3));
                data.setop2(rs.getString(4));
                data.setop3(rs.getString(5));
                data.setop4(rs.getString(6));
                list.add(data);
                data = null;
            }
            con.close();
            
        }catch (Exception e) 
        {
            System.out.println(e);
        }
        max = list.size();
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=0;i<list.size();i++)
        {
            ans.add("Z");
        }
        
        session.setAttribute("list",list);
        session.setAttribute("index",k);
        session.setAttribute("size", max);
        session.setAttribute("ans", ans);
        session.setAttribute("sub",sub);
        response.sendRedirect("quiz.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("adngjloksdhguahbsahbg");
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
