package com.fpoly.service;

import com.fpoly.model.Staff;
import com.fpoly.utils.CookieUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Lab3Service {
    ResourceBundle rb = ResourceBundle.getBundle("messenge");

    public String fillView(String uri, HttpServletRequest req){
        String view = "";
        if (uri.contains("upload-file")) {
            view = "/views/lab3/uploadFile.jsp";
        } else if (uri.contains("beanutils")) {
            view = "/views/lab3/beanUtils.jsp";
        } else if (uri.contains("dang-ki")) {
            view = "/views/lab3/dangKi.jsp";
        } else if (uri.contains("dang-nhap")) {
            req.setAttribute("display", "none");
            req.setAttribute("username", CookieUtil.getCookieUtil().get("username", req));
            req.setAttribute("password", CookieUtil.getCookieUtil().get("password", req));
            req.setAttribute("remember", CookieUtil.getCookieUtil().get("remember", req));
            view = "/views/lab3/login.jsp";
        } else if(uri.contains("send-email")){
            view = "/views/lab3/sendEmail.jsp";
        }
        return view;
    }

    public void uploadFile(HttpServletRequest req) throws IOException, ServletException {
        String path = req.getServletContext().getRealPath("/images");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Part photo = req.getPart("photo_file");
        File photoFile = new File(dir, photo.getSubmittedFileName());
        photo.write(photoFile.getAbsolutePath());
        Part doc = req.getPart("doc_file");
        File docFile = new File(dir, doc.getSubmittedFileName());
        doc.write(docFile.getAbsolutePath());
        req.setAttribute("img", photoFile);
        req.setAttribute("doc", docFile);
    }

    public void beanUtils(HttpServletRequest req){
        Staff staff = new Staff();
        try {
            BeanUtils.populate(staff, req.getParameterMap());
            req.setAttribute("staff",staff);
            System.out.println(staff.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dangKi(HttpServletRequest req){
        Staff staff = new Staff();
        try {
            BeanUtils.populate(staff, req.getParameterMap());
            String path = req.getServletContext().getRealPath("/images");
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = req.getPart("photo_file");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            staff.setHinhAnh(photoFile.getName());
            System.out.println(staff.toString());
            req.setAttribute("staff",staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMail(String to, String tieuDe, String noiDung, String path, Part part) throws MessagingException, IOException {
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
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("mrthanh260801@gmail.com"));
        mimeMessage.setRecipients(Message.RecipientType.TO,to);
        mimeMessage.setSubject(tieuDe,"utf-8");
        mimeMessage.setText(noiDung, "utf-8","html");
        mimeMessage.setReplyTo(mimeMessage.getFrom());
        System.out.println(path);
        if(!path.isEmpty()){
            File dir = new File("C:\\file");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, part.getSubmittedFileName());
            part.write(file.getAbsolutePath());
            File fileSend = new File("C:\\file"+path);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setDataHandler(new DataHandler(new FileDataSource(file)));
            mimeBodyPart.setFileName(file.getName());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            mimeMessage.setContent(multipart);
        }

        Transport.send(mimeMessage);
    }

}
