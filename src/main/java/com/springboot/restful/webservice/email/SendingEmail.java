package com.springboot.restful.webservice.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendingEmail {
	
	private static final String host="smtp.gmail.com";
	private static final String fromAddress="practice.fatma@gmail.com";
	private static final String applicationSpecificPassword = "vuudvohvzjhecamh";
	private String toAddress;
	private String subject;
	private String content;
	
	public SendingEmail() {
		super();
	}
	
	public SendingEmail(String toAddress, String subject, String content) {
		this.toAddress=toAddress;
		this.subject=subject;
		this.content=content;
	}
	
	public void sendEmail() {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromAddress, applicationSpecificPassword);
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            message.setSubject(subject);
           // message.setText(content);
            
            message.setContent(content,  "text/html");

            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

	}
	
	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public static String getFromaddress() {
		return fromAddress;
	}

	public static String getApplicationspecificpassword() {
		return applicationSpecificPassword;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static String getHost() {
		return host;
	}

}
