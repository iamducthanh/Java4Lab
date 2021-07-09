package com.fpoly.utils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EmailUtil {
    public static void sendMail(String to, String tieuDe, String noiDung) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        properties.setProperty("mail.smtp.host","smtp.gmail.com");
        properties.setProperty("mail.smtp.port","587");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = "mrthanh260801@gmail.com";
                String password = "adgjadgj";
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("mrthanh260801@gmail.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO,to);
            mimeMessage.setSubject(tieuDe,"utf-8");
            mimeMessage.setText(noiDung, "utf-8","html");
            mimeMessage.setReplyTo(mimeMessage.getFrom());
            Transport.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
