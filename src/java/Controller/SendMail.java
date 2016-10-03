/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author Sohil Chamadia
 */
public class SendMail extends HttpServlet {

      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        RequestDispatcher robj = null;    
        
            String Toname = String.valueOf(request.getAttribute("name"));
            String Toemail = String.valueOf(request.getAttribute("email"));
           String msg_info = String.valueOf(request.getAttribute("msg_info"));
            String path = String.valueOf(request.getAttribute("path"));
               String from = "sohilchamadia8@gmail.com";
String to[] = {Toemail};
String subject = "Welcome " + Toname;
String bodyText = "Congratulations " + Toname +", to become a member a part of us.We hope that you have a bright future.";


Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.auth", "true");
props.put("mail.debug", "true");
props.put("mail.smtp.port", "465");
props.put("mail.smtp.socketFactory.port", "465");
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");

Session s = Session.getInstance(props,new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication("sohilchamadia8@gmail.com", "saigal1204");
}
});


try {
MimeMessage message = new MimeMessage(s);
message.setFrom(new InternetAddress(from));
for(int i=0;i<to.length;i++){
message.setRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
message.setSubject(subject);
message.setSentDate(new Date());

//
// Set the email message text.
//
MimeBodyPart messagePart = new MimeBodyPart();
messagePart.setText(bodyText);

//
// Set the email attachment file
//
/*
String filename = "‪F:\\a.txt";
MimeBodyPart attachmentPart = new MimeBodyPart();
FileDataSource fileDataSource = new FileDataSource(filename) {
@Override
public String getContentType() {
return "application/octet-stream";
}
};
attachmentPart.setDataHandler(new DataHandler(fileDataSource));
attachmentPart.setFileName(filename);
*/
Multipart multipart = new MimeMultipart();
multipart.addBodyPart(messagePart);
// multipart.addBodyPart(attachmentPart);

message.setContent(multipart);

Transport.send(message);

   request.setAttribute("msg",msg_info);
                 robj = request.getRequestDispatcher(path);
                robj.forward(request, response);
 
}
} catch (MessagingException e) {
                 request.setAttribute("msg","Error occur while sending Mail" + e.toString());
                 robj = request.getRequestDispatcher(path);
                robj.forward(request, response);
 
}

        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
