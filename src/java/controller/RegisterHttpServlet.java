 package controller;
import dto.userinfodto;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.mentorData;
import model.offeredCourses;
import model.showChart;
import model.userRegister;
@MultipartConfig(maxFileSize = 16177215)
public class RegisterHttpServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        HttpSession session= req.getSession(true);
        int ccn=1,ccid=0;
        boolean f=false;
        Part filePart=req.getPart("picture");
        System.out.println("filePart"+filePart);
        InputStream inputStream = null;
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtains input stream of the upload file
            //the InputStream will point to a stream that contains
            //the contents of the file
            inputStream = filePart.getInputStream();
        }
        String uname=req.getParameter("uname");
        String ubranch=req.getParameter("ubranch");
        String usem=req.getParameter("usem");
        String ugen=req.getParameter("ugen");
        String umail=req.getParameter("umail");
        String uphone=req.getParameter("uphone");
        String upass=req.getParameter("upass");
        String ucpass=req.getParameter("ucpass");
        userinfodto uid=new userinfodto();
        uid.setUbranch(ubranch);
        uid.setUcpass(ucpass);
        uid.setUsem(usem);
        uid.setUmail(umail);
        uid.setUgen(ugen);
        uid.setUphone(uphone);
        uid.setUname(uname);
        uid.setUpass(upass);
        uid.setInputStream(inputStream);
        userRegister ureg=new userRegister();
        boolean checkRegStatus=false;
        try {
            checkRegStatus = ureg.registerUser(uid);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterHttpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        offeredCourses oc=new offeredCourses();
        ArrayList<String> courseinfo= new ArrayList<String>();
        ArrayList<String> courseid= new ArrayList<String>();
        ArrayList<String> coursename= new ArrayList<String>();
        courseinfo=oc.courseCheck();
        int noOfCourses=oc.bus();
        while(ccid<courseinfo.size())
        {
            courseid.add((String)courseinfo.get(ccid));
            ccid=ccid+2;
        }
        while(ccn<courseinfo.size())
        {
            coursename.add((String)courseinfo.get(ccn));
            ccn=ccn+2;
        }
       String numOfCourses= Integer.toString(noOfCourses);
       ArrayList<Integer>getCourseCount=new ArrayList<Integer>();
         showChart sc= new showChart();
         for(int i=0;i<courseid.size();i++)
         {
             getCourseCount.add(sc.getCount(courseid.get(i)));
         }
         System.out.println("courseNAME:"+coursename);
         System.out.println("getCourseCount"+getCourseCount);
        //ArrayList<String> courseid= oc.getCourseid();
        //ArrayList<String> coursename=oc.getCoursename();
        ArrayList<String>dataMentor=new ArrayList<String>();
         mentorData md=new mentorData();
         dataMentor=md.getMentorDetail();
        if(checkRegStatus)
        {
            session.setAttribute("uname", uname);
            session.setAttribute("umail", umail);
            session.setAttribute("ubranch", ubranch);
            session.setAttribute("ugen", ugen);
            session.setAttribute("usem", usem);
            session.setAttribute("uphone", uphone);
            session.setAttribute("upass", upass);
            session.setAttribute("numOfCourses", numOfCourses);
            session.setAttribute("f", f);
           session.setAttribute("courseid", courseid);
           session.setAttribute("coursename", coursename);
           session.setAttribute("getCourseCount", getCourseCount);
            session.setAttribute("dataMentor", dataMentor);
            resp.sendRedirect("slogin.jsp");
            
        }
        else
        {
            resp.sendRedirect("index.jsp");
        }
    }
    
}
