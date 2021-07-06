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

    @Inject
    private UserService userService;

    static List<Lab4UserModel> listUser = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = lab4Service.fillView(req);
        UserEntity userEntity = userService.findByUsernameAndPassword("admin", "123");
        System.out.println(userEntity.getFullname());
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("user-management")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            Boolean remember = null;
            if(req.getParameter("remember") == null){
               remember = false;
            } else {
                remember = true;
            }
            listUser.add(new Lab4UserModel(userName, password, remember));
            req.setAttribute("listUser", listUser);
            view = "/views/lab4/userManagement.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req,resp);
    }
}
