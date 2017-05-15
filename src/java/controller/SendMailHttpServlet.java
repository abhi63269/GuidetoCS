package controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SendMailHttpServlet extends HttpServlet 
{

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        String mentormailname=req.getParameter("mentormailname");
         String from1=req.getParameter("from");
          String gpassword=req.getParameter("gpassword");
         String subject1=req.getParameter("subject");
         String uiux=req.getParameter("uiux");
          try{
            String host ="smtp.gmail.com" ;
            String user = from1;
            String pass = gpassword;
            String to = mentormailname;
            String from = from1;
            String subject = subject1;
            String messageText = uiux;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
 
        //System.out.println("mentormailname"+mentormailname);
        resp.sendRedirect("dashboard.jsp");
    }
    
}
