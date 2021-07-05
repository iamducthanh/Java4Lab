package com.fpoly.controller;

import com.fpoly.service.Lab1Service;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/lab1"})
public class Lab1Controller extends HttpServlet {
    @Inject
    private Lab1Service lab1Service = new Lab1Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String view = lab1Service.fillView(type, req);
        System.out.println(view);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String view = "";
        String lab = req.getParameter("lab");
        if(lab != null && lab.equals("hinhchunhat")){
            req.setAttribute("display", "none");
            String chieuDai = req.getParameter("chieuDai");
            String chieuRong = req.getParameter("chieuRong");
            try {
                Double chieuDaiD = Double.valueOf(chieuDai);
                Double chieuRongD = Double.valueOf(chieuRong);
                req.setAttribute("dienTich", Double.valueOf(Math.round(chieuDaiD * chieuRongD * 100)) / 100);
                req.setAttribute("chuVi", (chieuDaiD + chieuRongD)*2);
            } catch (Exception e){
                req.setAttribute("display", "unset");
                req.setAttribute("messenge","Vui lòng nhập 1 số!");
            }
            view = "views/lab1/hinhChuNhat.jsp";
        } else {
            view = "views/lab1/hello.jsp";
            String name = req.getParameter("name");
            req.setAttribute("name", name);
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }
}
