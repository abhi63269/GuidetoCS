package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.existingCourses;
import model.retrieveClassContent;
import org.apache.catalina.ha.session.DeltaSession;
public class CourseDisplayHttpServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("doPost Chala");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        HttpSession session = req.getSession(true);
        int i=0,j=1,a=0,b=1,noOfVideos=0,noOfBooks=0;
        String umail=(String)session.getAttribute("umail");
        String proid=req.getParameter("proid");
        System.out.println("proid"+proid);
        existingCourses ec=new existingCourses();
        boolean updateStatus=ec.checkCourses(proid, umail);
        retrieveClassContent rcc=new retrieveClassContent();
        ArrayList<String>videoContent=new ArrayList<String>();
        ArrayList<String>videoLink=new ArrayList<String>();
        ArrayList<String>videoName=new ArrayList<String>();
        ArrayList<String>booksContent=new ArrayList<String>();
        ArrayList<String>booksLink=new ArrayList<String>();
        ArrayList<String>booksName=new ArrayList<String>();
        videoContent=rcc.getClassContent(proid);
        booksContent=rcc.giveback();
        noOfVideos=rcc.getNoOfVideos();
        noOfBooks=rcc.getNoOfBooks();
        rcc.getInfoTech(proid);
        String courseName=rcc.getCourseName();
        String courseDesc=rcc.getCourseDesc();
        while(i<videoContent.size())
        {
            videoLink.add(videoContent.get(i));
            i=i+2;
        }
        while(j<videoContent.size())
        {
            videoName.add(videoContent.get(j));
            j=j+2;
        }
        while(a<booksContent.size())
        {
            booksLink.add(booksContent.get(a));
            a=a+2;
        }
        while(b<booksContent.size())
        {
            booksName.add(booksContent.get(b));
            b=b+2;
        }
        
        String noOfvideos=Integer.toString(noOfVideos);
        String noOfbooks=Integer.toString(noOfBooks);
        System.out.println("video name:"+videoName);
        System.out.println("video link:"+videoLink);
        System.out.println("noOfVideos"+noOfVideos);
        System.out.println("noOfBooks"+noOfBooks);
        session.setAttribute("videoLink", videoLink);
        session.setAttribute("videoName", videoName);
        session.setAttribute("booksLink",booksLink);
        session.setAttribute("booksName",booksName);
        session.setAttribute("noOfvideos", noOfvideos);
        session.setAttribute("noOfbooks",noOfbooks);
        session.setAttribute("courseName",courseName);
        session.setAttribute("courseDesc",courseDesc);
        session.setAttribute("proid", proid);
        resp.sendRedirect("content.jsp");
    }
    
}
