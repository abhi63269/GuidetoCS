package controller;
import dto.userupdatedto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.userUpdateAccount;
public class UpdateUserAccountHttpServlet extends HttpServlet 
{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String umail=req.getParameter("umail");
        String npass=req.getParameter("npass");
        String cpass=req.getParameter("cpass");
        userupdatedto uudto=new userupdatedto();
        uudto.setCpass(cpass);
        uudto.setNpass(npass);
        uudto.setUmail(umail);
        userUpdateAccount uua=new userUpdateAccount();
        boolean changes=uua.edit(uudto);
        if(changes)
        {
            resp.sendRedirect("dashboard.jsp");
        }
    }
    
}
