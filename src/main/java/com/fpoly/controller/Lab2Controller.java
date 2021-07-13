package com.fpoly.controller;

import com.fpoly.service.Lab2Service;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/lab2/tam-giac", "/lab2/dang-ki","/lab2/signup"})
public class Lab2Controller extends HttpServlet {
    @Inject
    private Lab2Service lab2Service;

    ResourceBundle rb = ResourceBundle.getBundle("messenge");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = lab2Service.fillView(uri, req);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("tam-giac")) {
            lab2Service.tamGiac(req, action);
            view = "/views/lab2/hinhTamGiac.jsp";
        } else if(uri.contains("dang-ki")) {
            lab2Service.dangKi(req);
            view = "/views/lab2/dangKi.jsp";
        } else {
            lab2Service.dangKi1(req);
            view = "/views/lab2/dangKi1.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
