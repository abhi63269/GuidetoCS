package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SignOutHttpServlet extends HttpServlet 
{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        System.out.println("HAHAHAHAHA");
        HttpSession session= req.getSession();
        PrintWriter out = resp.getWriter();
        session.invalidate();
        out.print("You are successfully logged out");
        out.close();
        resp.sendRedirect("slogin.jsp");
    }
    
}
