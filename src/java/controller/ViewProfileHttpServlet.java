package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.viewProfileData;
public class ViewProfileHttpServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        int i=1,j=2;
        HttpSession session=req.getSession(true);
        String viewName=req.getParameter("sear");
        System.out.println("sear"+viewName);
        session.setAttribute("viewName",viewName);
        viewProfileData vpd=new viewProfileData();
        ArrayList<String> viewInfo=new ArrayList<String>();
        ArrayList<String> viewCourseInfo=new ArrayList<String>();
        
        viewCourseInfo=vpd.viewData(viewName);
        String viewMail=vpd.getMail(viewName);
        String viewDept=vpd.getViewDept();
        //System.out.println("viewInfo"+viewInfo);
        String noOfUserEnroll=Integer.toString(vpd.yeol());
        System.out.println("viewCourseInfo"+viewCourseInfo);
        
        System.out.println("viewMail"+viewMail);
        
        System.out.println("viewDept"+viewDept);
        session.setAttribute("viewDept",viewDept);
        session.setAttribute("viewMail",viewMail);
        session.setAttribute("noOfUserEnroll",noOfUserEnroll);
        session.setAttribute("viewCourseInfo",viewCourseInfo);
        resp.sendRedirect("vp.jsp");
    }
    
}
