package com.fpoly.controller;

import com.fpoly.service.Lab3Service;
import com.fpoly.utils.CookieUtil;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/lab3/upload-file", "/lab3/beanutils", "/lab3/dang-ki", "/dang-nhap", "/lab3/send-email"})
@javax.servlet.annotation.MultipartConfig
public class Lab3Controller extends HttpServlet {
    ResourceBundle rb = ResourceBundle.getBundle("messenge");
    @Inject
    private Lab3Service lab3Service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = lab3Service.fillView(uri, req);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String view = "";
        if (uri.contains("upload-file")) {
            view = "/views/lab3/uploadFile.jsp";
            lab3Service.uploadFile(req);
        } else if (uri.contains("beanutils")) {
            view = "/views/lab3/beanUtils.jsp";
            lab3Service.beanUtils(req);
        } else if(uri.contains("dang-ki")){
            view = "/views/lab3/dangKi.jsp";
            lab3Service.dangKi(req);
        } else if (uri.contains("dang-nhap")) {
            req.setAttribute("display", "none");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")){
                String remember = req.getParameter("remember");
                int hours = (remember == null) ? 0 : 30*24;
                CookieUtil.getCookieUtil().add("username", username, hours, resp);
                CookieUtil.getCookieUtil().add("password", password, hours, resp);
                CookieUtil.getCookieUtil().add("remember", "on", hours, resp);
                resp.sendRedirect(req.getContextPath()+ "/lab");
                return;
            }else {
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("display", "unset");
                req.setAttribute("messenge",rb.getString("loginFalse"));
            }
            view = "/views/lab3/login.jsp";
        } else if(uri.contains("send-email")){
            String to = req.getParameter("to");
            String tieuDe = req.getParameter("tieuDe");
            String noiDung = req.getParameter("noiDung");
            String filePath = req.getParameter("fileDinhKem");
            Part part = req.getPart("tepDinhKem");
            String path = req.getParameter("fileDinhKem");
            try {
                if(path.length() > 0){
                    System.out.println("có pat");
                    lab3Service.sendMail(to,tieuDe,noiDung,filePath,part);
                } else {
                    System.out.println("no part");
                    lab3Service.sendMail(to,tieuDe,noiDung,filePath,null);
                }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            view = "/views/lab3/sendEmail.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
