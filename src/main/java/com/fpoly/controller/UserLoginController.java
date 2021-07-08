package com.fpoly.controller;

import com.fpoly.entity.UserEntity;
import com.fpoly.service.UserLoginService;
import com.fpoly.service.impl.UserService;
import com.fpoly.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/sign-in", "/sign-up", "/forgot-password", "/logout"})
public class UserLoginController extends HttpServlet {
    @Inject
    private UserService userService;

    @Inject
    private UserLoginService userLoginService;

    ResourceBundle rb = ResourceBundle.getBundle("messenge");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("sign-in")) {
            String type = req.getParameter("type");
            if(type != null && type.equals("sign-up-success")){
                req.setAttribute("messengeSuccess", "Đăng kí thành công, bạn có thể đăng nhập!");
            }
            view = "/views/lab5/signin.jsp";
        } else if (uri.contains("sign-up")) {
            view = "/views/lab5/signup.jsp";
        } else if (uri.contains("forgot-password")) {
            view = "/views/lab5/forgotpassword.jsp";
        } else if (uri.contains("logout")) {
            SessionUtil.getSession().removeUser(req, "USER");
            view = "/views/trangchu.jsp";
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
        if (uri.contains("sign-in")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            UserEntity userEntity = userService.findByUsernameAndPassword(username, password);
            if (userEntity == null) {
                view = "/views/lab5/signin.jsp";
                req.setAttribute("messenge", rb.getString("loginFalse"));
                req.setAttribute("username", username);
                req.setAttribute("password", password);
            } else {
                SessionUtil.getSession().putUser(req, "USER", userEntity);
                resp.sendRedirect(req.getContextPath());
                return;
            }
        } else if (uri.contains("sign-up")) {
            if(userLoginService.createAccount(req)){
                resp.sendRedirect(req.getContextPath()+"/sign-in?type=sign-up-success");
                return;
            }
            view = "/views/lab5/signup.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
