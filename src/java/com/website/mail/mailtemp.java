/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.website.mail;

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
public class mailtemp {
    private boolean sendmailfunction(String name, String f_name,String to,String by,String subject) throws MessagingException {
        String host = "smtp.gmail.com";
        String Password = "akhtar079723";
        String from = "multikbis@gmail.com";
        String toAddress = to;//"nabeelabdullah.11@gmail.com";
        String filename = f_name;//"D:\\New Text Document.txt";
        String send_by="this mail is send my "+by;
        // Get system properties
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", Password);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.EnableSSL.enable","true");
            Session session = Session.getInstance(props, null);
            MimeMessage msg = new MimeMessage(session);
            String encodingOptions = "text/html; charset=UTF-8";
            msg.setHeader("Content-Type", encodingOptions);
            msg.setHeader("Content-Transfer-Encoding", "quoted-printable");
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            msg.setSubject("Some subject", "UTF-8");
            msg.setText(send_by, "UTF-8");
            msg.setSubject(subject);//("JavaMail Attachment");

        BodyPart messageBodyPart = new MimeBodyPart();

        messageBodyPart.setText(send_by);////("Here's the file");

        Multipart multipart = new MimeMultipart();

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();

        DataSource source = new FileDataSource(filename);

        messageBodyPart.setDataHandler(new DataHandler(source));

        messageBodyPart.setFileName(name);

        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);

        try {
            Transport transport = session.getTransport("smtps");
            transport.connect(host, from, Password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (SendFailedException sfe) {

            System.out.println(sfe);
        }
        return true;
    }
    public static void main(String args[]){
        try {
            mailtemp sm=new mailtemp();
            sm.sendmailfunction(null,null, null,null,null);
        } catch (MessagingException ex) {
            System.out.println(ex);
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean sendmail(String name,String path,String to,String by,String subject)
    {
        try {
            sendmailfunction(name,path, to, by, subject);
        } catch (MessagingException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
