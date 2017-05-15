package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OnNextPress", urlPatterns = {"/OnNextPress"})
public class OnNextPress extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Process Request Accepted");
    }
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
        out.println("DoGet Accepted");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String rad = (String) session.getAttribute("rad");
        int k = (Integer) session.getAttribute("index");
        int max = (Integer) session.getAttribute("size");
        System.out.println("Value = "+max);
        ArrayList<String> ans = (ArrayList<String>) session.getAttribute("ans");
        if(ans.get(k)!=null)
        { 
            ans.set(k, rad);
        }
        else
        {
            ans.add(rad);
        }
        session.setAttribute("ans",ans);
        k = (k+1)%max;
        session.setAttribute("index",k);
        response.sendRedirect("quiz.jsp");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
