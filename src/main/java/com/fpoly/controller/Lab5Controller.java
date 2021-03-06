package com.fpoly.controller;

import com.fpoly.entity.UserEntity;
import com.fpoly.service.Lab5Service;
import com.fpoly.service.impl.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/lab5/test-jpa","/lab5/quan-li-user","/lab5/quan-li-user/add","/lab5/quan-li-user/update", "/lab5/add", "/lab5/delete", "/lab5/update", "/lab5/find-all", "/lab5/find-by-role", "/lab5/find-by-keyword", "/lab5/find-one", "/lab5/find-page"})
public class Lab5Controller extends HttpServlet {
    @Inject
    private Lab5Service lab5Service;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("test-jpa")) {
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("lab5/quan-li-user")) {
            String action = req.getParameter("action");
            if(action != null && action.equals("remove")){
                String id = req.getParameter("id");
                userService.removeUser(Integer.parseInt(id));
                resp.sendRedirect(req.getContextPath()+"/lab5/quan-li-user?type=removedone");
                return;
            } else if(action != null && action.equals("edit")){
                int id = Integer.parseInt(req.getParameter("id"));
                UserEntity userEntity = userService.findById(id);
                req.setAttribute("user", userEntity);
                req.setAttribute("btnEdit", "on");
                view = "/views/lab5/quanliuser.jsp";
            } else {
                String type = req.getParameter("type");
                if(type != null && type.equals("removedone")){
                    req.setAttribute("messenge","X??a th??nh c??ng!");
                }
                view = "/views/lab5/quanliuser.jsp";
            }
            System.out.println("abc");
            List<UserEntity> listUser = userService.findAll(); // load d??? li???u ??? ????y
            req.setAttribute("listUser", listUser);
        }

        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("lab5/add")) {
            lab5Service.addUser(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("delete")) {
            lab5Service.deleteUser(req);
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("lab5/update")) {
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
        } else if(uri.contains("quan-li-user/add")){
            try {
                if(lab5Service.addUserBai3(req)){
                    resp.sendRedirect(req.getContextPath()+"/lab5/quan-li-user");
                    return;
                } else {
                    List<UserEntity> listUser = userService.findAll();
                    req.setAttribute("listUser", listUser);
                    view = "/views/lab5/quanliuser.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(uri.contains("quan-li-user/update")){
            if(lab5Service.updateUserBai3(req)){
//                doGet(req, resp);
                resp.sendRedirect(req.getContextPath()+"/lab5/quan-li-user"); // d??ng n??y s??? g???i l???i doget
                // ????y l?? update th??nh c??ng
                return;
            } else {
                // ch??? n??y l?? update ko ??c
                List<UserEntity> listUser = userService.findAll();
                req.setAttribute("btnEdit","on");
                req.setAttribute("listUser", listUser);
                view = "/views/lab5/quanliuser.jsp";
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
