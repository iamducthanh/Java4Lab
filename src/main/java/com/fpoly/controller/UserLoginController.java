package com.fpoly.controller;

import com.fpoly.entity.UserEntity;
import com.fpoly.service.UserLoginService;
import com.fpoly.service.impl.UserService;
import com.fpoly.utils.CookieUtil;
import com.fpoly.utils.EmailUtil;
import com.fpoly.utils.SessionUtil;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/user-profile", "/sign-in", "/sign-up","/forgot-change", "/forgot-password", "/logout", "/comfirm-email","/change-password"})
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
            String status = req.getParameter("status");
            if(status != null){
                int index = status.lastIndexOf("@");
                String maSoMk = status.substring(0,index);
                String maEmail = status.substring(index+1 , status.length());
                String cookieMa = CookieUtil.get("MALAYLAIMK", req);
                String cookieEmail = CookieUtil.getCookieUtil().get("EMAILLAYMK",req);
                String maHoaMaLayMk = DigestUtils.md5Hex(String.valueOf(cookieMa));
                String maHoaEmail = DigestUtils.md5Hex(String.valueOf(cookieEmail));
                if(maHoaEmail.equals(maEmail) && maHoaMaLayMk.equals(maSoMk)){
                    view = "/views/lab5/changePasswordForgot.jsp";
                } else {
                    view = "/views/lab5/forgotpassword.jsp";
                }
            } else {
                view = "/views/lab5/forgotpassword.jsp";
            }
        } else if (uri.contains("logout")) {
            SessionUtil.getSession().removeUser(req, "USER");
            view = "/views/trangchu.jsp";
        } else if (uri.contains("comfirm-email")) {
            String status = req.getParameter("status");
            if(status != null && status.equals("comfirm-false")){
                req.setAttribute("messenge", "Mã xác thực không đúng, vui lòng kiểm tra lại!");
            } else {
                int so = (int) (Math.random() * ((999999 - 111111) + 1) + 111111);
                int hours = 30*24;
                CookieUtil.getCookieUtil().add("MAXACTHUC", String.valueOf(so), hours, resp);
                EmailUtil.sendMail(req.getParameter("email"), "Xác thực tài khoản", "Mã xác thực tài khoản của bạn là: "+so);
                req.setAttribute("email", req.getParameter("email"));
            }
            view = "/views/lab5/comfirmEmail.jsp";
        } else if (uri.contains("change-password")) {
            view = "/views/lab5/changepassword.jsp";
        } else if (uri.contains("user-profile")) {
            UserEntity userEntity = (UserEntity) SessionUtil.getSession().getUser(req, "USER");
            req.setAttribute("user", userEntity);
            view = "/views/lab5/userprofile.jsp";
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
                resp.sendRedirect(req.getContextPath()+"/comfirm-email?email="+req.getParameter("email"));
                return;
            }
            view = "/views/lab5/signup.jsp";
        } else if (uri.contains("comfirm-email")) {
            String maxacthuc = req.getParameter("maxacthuc");
            String maConfirm = CookieUtil.getCookieUtil().get("MAXACTHUC", req);
            System.out.println(maxacthuc);
            System.out.println(maConfirm);
            if(maConfirm.equals(maxacthuc)){
                userService.insertUser((UserEntity) SessionUtil.getSession().getUser(req,"USERTEMP"));
                resp.sendRedirect(req.getContextPath()+"/sign-in?type=sign-up-success");
                return;
            } else {
                resp.sendRedirect(req.getContextPath()+"/comfirm-email?status=comfirm-false");
                return;
            }
        } else if (uri.contains("change-password")) {
            String oldPassword = req.getParameter("passwordold");
            String newPassword = req.getParameter("passwordnew");
            String comfirmPassword = req.getParameter("passwordnewcomfirm");
            UserEntity userEntity = (UserEntity) SessionUtil.getSession().getUser(req, "USER");
            String username = userEntity.getPassword();
            if(oldPassword.equals(userEntity.getPassword())){
                if(newPassword.equals(comfirmPassword)){
                    userEntity.setPassword(newPassword);
                    userService.updateUser(userEntity);
                    resp.sendRedirect(req.getContextPath()+"/lab?status=change-password-success");
                    return;
                } else {
                    req.setAttribute("messenge","2 mật khẩu mới phải giống nhau!");
                }
            } else {
                req.setAttribute("messenge","Mật khẩu cũ không chính xác!");
            }
            req.setAttribute("oldpassword", oldPassword);
            req.setAttribute("newpassword", newPassword);
            req.setAttribute("newpasswordcomfirm", comfirmPassword);
            view = "/views/lab5/changepassword.jsp";
        } else if (uri.contains("forgot-password")) {
            userLoginService.forgotPassword(req, resp);
            view = "/views/lab5/forgotpassword.jsp";
        } else if(uri.contains("forgot-change")){
            String newPassword = req.getParameter("newpassword");
            String comfirmPassword = req.getParameter("comfirmpassword");
            if(newPassword.equals(comfirmPassword)){
                String cookieEmail = CookieUtil.getCookieUtil().get("EMAILLAYMK",req);
                UserEntity userEntity = userService.findByEmail(cookieEmail);
                userEntity.setPassword(newPassword);
                userService.updateUser(userEntity);
                resp.sendRedirect(req.getContextPath()+"/lab?status=change-password-success");
                return;
            } else {
                req.setAttribute("newpassword", newPassword);
                req.setAttribute("comfirmpassword", comfirmPassword);
                req.setAttribute("messenge","2 mật khẩu phải giống nhau!");
                view = "/views/lab5/changePasswordForgot.jsp";
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
