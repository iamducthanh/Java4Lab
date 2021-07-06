package com.fpoly.controller;

import com.fpoly.service.Lab5Service;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/lab5/test-jpa","/lab5/quan-li-user", "/lab5/add", "/lab5/delete", "/lab5/update", "/lab5/find-all", "/lab5/find-by-role", "/lab5/find-by-keyword", "/lab5/find-one", "/lab5/find-page"})
public class Lab5Controller extends HttpServlet {
    @Inject
    private Lab5Service lab5Service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = lab5Service.fillView(req);
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("add")) {
            lab5Service.addUser(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("delete")) {
            lab5Service.deleteUser(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("update")) {
            lab5Service.updateUser(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("find-all")) {
            lab5Service.findAll(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("find-by-role")) {
            lab5Service.findByRole(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("find-by-keyword")) {
            lab5Service.findByKeyword(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("find-one")) {
            lab5Service.findOne(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("find-page")) {
            lab5Service.findByPage(req);
            view = "/views/lab5/testjpa.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
