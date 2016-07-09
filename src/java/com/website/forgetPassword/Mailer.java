package com.website.forgetPassword;
//
////package mailpack;
//
//
//import java.util.Properties;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class Mailer {
//	public static String send(String to,String sub,String topic) {
//		final String subject ="Change Password";
//		final String msg = sub;//"You Are Successfully Verified By The Admin Of Eclass(Integral University) Web-Application";
//		final String user ="mail.multikbis@gmail.com";// "multikbis@gmail.com";// change accordingly
//		final String pass =  "zamaniashanu12345";//"alhtar079723";
//      String m="send";
//                //String Password =
//       // String from = 
//                
//                
//		// 1st step) Get the session object
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//
//		Session session = Session.getDefaultInstance(props,
//				new javax.mail.Authenticator() {
//					protected PasswordAuthentication getPasswordAuthentication() {
//						return new PasswordAuthentication(user, pass);
//					}
//				});
//		// 2nd step)compose message
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(user));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
//					to));
//			message.setSubject(subject);
//			message.setText(msg);
//
//			// 3rd step)send message
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//                    m=e.toString();
//			//throw new RuntimeException(e);
//		}
//return m;
//	}
//        public static void main(String m[])
//        {
//           
//            
//                    
//        }
//}



//package mailpack;


import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	public static String send(String to,String sub,String topic) {
		final String subject ="Change Password";
		final String msg =sub;// "You Are Successfully Verified By The Admin Of Eclass(Integral University) Web-Application";
		final String user ="mail.multikbis@gmail.com";// "multikbis@gmail.com";// change accordingly
		final String pass =  "zamaniashanu@12345";//"alhtar079723";
                 String m="send";
                //String Password =
       // String from = 
                
                
		// 1st step) Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");// change accordingly
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, pass);
					}
				});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject(subject);
			//message.setText(msg);
                        message.setContent(msg, "text/html");
			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
                    m=e.toString();
			//throw new RuntimeException(e);
		}
                System.out.println(m);
return m;
	}
        public static void main(String m[])
        {
           
            
                    send("mail.multikbis@gmail.com", null, null);
        }
}
