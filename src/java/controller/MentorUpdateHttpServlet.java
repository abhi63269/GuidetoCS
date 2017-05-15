package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.updateMentor;
import org.apache.catalina.tribes.util.Arrays;
public class MentorUpdateHttpServlet extends HttpServlet 
{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String cm=req.getParameter("cm");
        if(cm==null)
        {
            String mentorcourseid=req.getParameter("mentorcourseid");
            String mentormail=Arrays.toString(req.getParameterValues("mentormail"));
            System.out.println("mentormail"+mentormail);
        String submentormail=mentormail.substring(1,mentormail.length()-1);
        System.out.println("submentormail"+submentormail);
        String[] splitmentormail=(String[])(submentormail.split(", "));
        ArrayList<String>updateMentor=new ArrayList<String>();
        for(int i=0;i<splitmentormail.length;i++)
        {
           updateMentor.add(splitmentormail[i]);
          
        }
         System.out.println("updateMentor"+updateMentor);
        updateMentor um=new updateMentor();
        um.updationMentor(updateMentor, mentorcourseid);

        }
        else
        {
            String delmentor=req.getParameter("delmentor");
            updateMentor um=new updateMentor();
            um.delMentor(delmentor);
        }
        
    }
    
}
