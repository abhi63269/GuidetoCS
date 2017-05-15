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

@WebServlet(name = "OnPrevPress", urlPatterns = {"/OnPrevPress"})
public class OnPrevPress extends HttpServlet {

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
        int k = (Integer) session.getAttribute("index");
        int max = (Integer) session.getAttribute("size");
        String rad = (String) session.getAttribute("rad");
        ArrayList<String> ans = (ArrayList<String>) session.getAttribute("ans");
        if(ans.get(k)!=null)
        { 
            ans.set(k, rad);
        }
        else
        {
            ans.add(rad);
        }
        if(k!=0)
        k--;
        else
        k = max-1;
        
        session.setAttribute("ans",ans);
        session.setAttribute("index",k);
        response.sendRedirect("quiz.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

