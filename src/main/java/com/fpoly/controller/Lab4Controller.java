package com.fpoly.controller;

import com.fpoly.entity.UserEntity;
import com.fpoly.model.Lab4UserModel;
import com.fpoly.service.Lab4Service;
import com.fpoly.service.impl.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/lab4/items","/lab4/user-management","/lab4/product-details"})
public class Lab4Controller extends HttpServlet {
    @Inject
    private Lab4Service lab4Service;

    static List<Lab4UserModel> listUser = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = lab4Service.fillView(req);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("user-management")) {
            StringBuilder error = new StringBuilder();
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            Boolean remember = null;
            if(req.getParameter("remember") == null){
                remember = false;
            } else {
                remember = true;
            }
            if(userName.isBlank() || password.isBlank()){
                error.append("Tên đăng nhập và mật khẩu đều không được để trống!");
            } else {
                if(!userName.matches("[a-z0-9]{1,20}")){
                    error.append("Tên đăng nhập không được chứa kí tự đặc biệt!");
                }
                for(Lab4UserModel user : listUser){
                    if(user.getUsername().equals(userName)){
                        error.append("Tên đăng nhập này đã tồn tại!");
                        break;
                    }
                }
            }
            if(!error.toString().isBlank()){
                req.setAttribute("username", userName);
                req.setAttribute("password", password);
                req.setAttribute("messenge", error.toString());
                req.setAttribute("remember", remember);
            } else {
                req.setAttribute("messengeSuccess","Thêm thành công!");
                listUser.add(new Lab4UserModel(userName, password, remember));
            }
            req.setAttribute("listUser", listUser);
            view = "/views/lab4/userManagement.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }
}
