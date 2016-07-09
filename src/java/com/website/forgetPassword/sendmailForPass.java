/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.forgetPassword;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author NABEEL
 */
public class sendmailForPass {
    private boolean sendmailfunction(String to,String by) throws MessagingException {
        String host = "smtp.gmail.com";
        String Password = "akhtar079723";
        String from = "multikbis@gmail.com";
        String toAddress = to;//"nabeelabdullah.11@gmail.com";
        //String filename = f_name;//"D:\\New Text Document.txt";
        // Get system properties
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String send_by="message send by "+by;
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));

        message.setRecipients(Message.RecipientType.TO, toAddress);

        message.setSubject("forget Password");//("JavaMail Attachment");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(send_by);////("Here's the file");

        Multipart multipart = new MimeMultipart();

       multipart.addBodyPart(messageBodyPart);

      //  messageBodyPart = new MimeBodyPart();

      //  DataSource source = new FileDataSource(filename);

      //  messageBodyPart.setDataHandler(new DataHandler(source));

     //   messageBodyPart.setFileName(name);

         multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
        return true;
    }
    public static void main(String args[]){
        try {
            sendmailForPass sm = new sendmailForPass();
            sm.sendmailfunction( null,null);
        } catch (MessagingException ex) {
            Logger.getLogger(sendmailForPass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean sendmail(String to,String by)
    {
        try {
            sendmailfunction(to, by);
        } catch (MessagingException ex) {
            Logger.getLogger(sendmailForPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
