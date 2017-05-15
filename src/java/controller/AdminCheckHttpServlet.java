package controller;
import dto.admindto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.adminCheckLog;
public class AdminCheckHttpServlet extends HttpServlet 
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
       String admail=req.getParameter("admail");
       String adpassword=req.getParameter("adpassword");
       admindto adto=new admindto();
       adto.setAdmail(admail);
       adto.setAdpassword(adpassword);
       adminCheckLog acl=new adminCheckLog();
       boolean checkAdminLogin=acl.adminCheck(adto);
       if(checkAdminLogin)
       {
           resp.sendRedirect("admin.jsp");
       }
       else
       {
           resp.sendRedirect("Index.html");
       }
    }

       
}
