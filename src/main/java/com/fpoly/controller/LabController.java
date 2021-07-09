package com.fpoly.controller;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/lab"})
public class LabController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        System.out.println(req.getRequestURL());
        if(status != null && status.equals("change-password-success")){
            req.setAttribute("messengeSuccess","Thay đổi mật khẩu thành công!");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/trangchu.jsp");
        rd.forward(req, resp);
    }
}
