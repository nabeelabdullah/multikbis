/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.mail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author akhtar
 */
public class MyMail extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           try {
            String host = "smtp.gmail.com";
            String to=request.getParameter("to");//"akhtarnoman1994@gmail.com";
            String from =request.getParameter("from");//"noman.akhtar2011@gmail.com";
            String what =request.getParameter("what");
    
            Properties p=new Properties();            
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", host);
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.auth","true");
            
            
            out.println("1");
            Session s;
            s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {System.err.println("2");
                        return new PasswordAuthentication(
                                "noman.akhtar2011@gmail.com", "akhtar079723");
                        }
                    });
            
            Message msg=new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Testing hai");
            msg.setText(what);
            
            Transport tr=s.getTransport("smtp");
            tr.connect(host, "nom123an", "akhtar079723");  
            tr.sendMessage(msg,msg.getAllRecipients());
            out.println("done");
            
            
            
            
            
        } catch (AddressException ex) {
           
        } catch (MessagingException ex) {
           
        }
        
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
