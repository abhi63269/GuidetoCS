package controller;
import dto.userLogClass;
import dto.userinfodto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.existingCourses;
import model.mentorData;
import model.offeredCourses;
import model.showChart;
import model.userCheckLog;
public class LoginHttpServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session= req.getSession(true);
        boolean f=true;
        int ccid=0,ccn=1;
        String umail=req.getParameter("umail");
        String upass=req.getParameter("upass");
        userLogClass ulc=new userLogClass();
        ulc.setUmail(umail);
        ulc.setUpass(upass);
        userCheckLog ucl=new userCheckLog();
        boolean checkLoginStatus=ucl.userCheck(ulc);
        String uname=ucl.giveBack();
        userinfodto uid=new userinfodto();
        uid=ucl.getUid();
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
      
        existingCourses ec=new existingCourses();
         ArrayList<String> enrolledCourseID=new ArrayList<String>();
         enrolledCourseID=ec.fetchCourses(umail);
         System.out.println("LOGINHTTP ENROLLCOURSEID"+enrolledCourseID);
         int countEnrollCourse=ec.retcount();
         System.out.println("LOGINHTTP ROWS"+countEnrollCourse);
         String numOfCoursesEnroll= Integer.toString(countEnrollCourse);
         ArrayList<Integer>getCourseCount=new ArrayList<Integer>();
         showChart sc= new showChart();
         for(int i=0;i<courseid.size();i++)
         {
             getCourseCount.add(sc.getCount(courseid.get(i)));
         }
         System.out.println("getCourseCount"+getCourseCount);
         ArrayList<String>dataMentor=new ArrayList<String>();
         mentorData md=new mentorData();
         dataMentor=md.getMentorDetail();
        if(checkLoginStatus)
        {
            session.setAttribute("ubranch", uid.getUbranch());
            session.setAttribute("upass", uid.getUpass());
            session.setAttribute("usem", uid.getUsem());
            session.setAttribute("uphone", uid.getUphone());
            session.setAttribute("ugen", uid.getUgen());
            session.setAttribute("uname", uname);
            session.setAttribute("umail", umail);
            session.setAttribute("noOfCourses", noOfCourses);
            session.setAttribute("numOfCourses", numOfCourses);
            session.setAttribute("courseid", courseid);
           session.setAttribute("coursename", coursename);
           session.setAttribute("f", f);
           session.setAttribute("enrolledCourseID", enrolledCourseID);
           session.setAttribute("countEnrollCourse", countEnrollCourse);
           session.setAttribute("numOfCoursesEnroll", numOfCoursesEnroll);
           session.setAttribute("getCourseCount", getCourseCount);
           session.setAttribute("dataMentor", dataMentor);
           resp.sendRedirect("dashboard.jsp");
        }
        else
        {
            resp.sendRedirect("slogin.jsp");
        }
    }
   
}
