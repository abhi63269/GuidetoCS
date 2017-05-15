package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.updateCourseContent;
import org.apache.catalina.tribes.util.Arrays;
public class AdminUpdateCourseHttpServlet extends HttpServlet 
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String coursed=req.getParameter("coursed");
        if(coursed==null)
        {
          String updatecourseid=req.getParameter("updatecourseid");
          String coursen=req.getParameter("coursen");
          String coursedesc=req.getParameter("coursedesc");
        System.out.println("updatecourseid"+updatecourseid);
        String ques=Arrays.toString(req.getParameterValues("ques"));
        String subques=ques.substring(1,ques.length()-1);
        String[] splitsubques=(String[])(subques.split(", "));
        String ques1=Arrays.toString(req.getParameterValues("ques1"));
        String subques1=ques1.substring(1,ques1.length()-1);
        String[] splitsubques1=(String[])(subques1.split(", "));
        String ques2=Arrays.toString(req.getParameterValues("ques2"));
        String subques2=ques2.substring(1,ques2.length()-1);
        String[] splitsubques2=(String[])(subques2.split(", "));
        String ques3=Arrays.toString(req.getParameterValues("ques3"));
        String subques3=ques3.substring(1,ques3.length()-1);
        String[] splitsubques3=(String[])(subques3.split(", "));
        ArrayList<String> updateVideoContent=new ArrayList<String>();
        ArrayList<String> updateBookContent=new ArrayList<String>();
        for(int i=0;i<splitsubques.length;i++)
        {
            updateVideoContent.add(splitsubques[i]);
            updateVideoContent.add(splitsubques1[i]);
        }
        for(int i=0;i<splitsubques2.length;i++)
        {
            updateBookContent.add(splitsubques2[i]);
            updateBookContent.add(splitsubques3[i]);
        }
        System.out.println("updateVideoContent"+updateVideoContent);
        System.out.println("updateBookContent"+updateBookContent);
       updateCourseContent ucc=new updateCourseContent();
       ucc.updateCourseOffered(updatecourseid, coursen, coursedesc);
       boolean checkVideoStatus=ucc.updateVideoCourse(updateVideoContent, updatecourseid);
       boolean checkBookStatus=ucc.updateBookCourse(updateBookContent, updatecourseid);  
       
        }
        else
        {
            String cid=req.getParameter("cid");
            updateCourseContent ucc=new updateCourseContent();
            ucc.deleteCourse(cid);
        }
        
        
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
    }
}
