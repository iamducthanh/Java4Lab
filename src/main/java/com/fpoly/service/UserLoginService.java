package com.fpoly.service;

import com.fpoly.entity.UserEntity;
import com.fpoly.service.impl.UserService;
import com.fpoly.utils.ValidateUtil;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

public class UserLoginService {
    @Inject
    private UserService userService;

    public boolean createAccount(HttpServletRequest req) {
        StringBuilder error = new StringBuilder();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String comfirmPassword = req.getParameter("comfirmPassword");
        if (!ValidateUtil.checkNull(username)) {
            error.append("Bạn không được để trống tên đăng nhập!\n");
        } else {
            if (!username.matches("[a-z0-9]{1,20}")) {
                error.append("Tên đăng nhập không được chứa kí tự đặc biệt!\n");
            } else {
                UserEntity userEntity = userService.findByUsername(username);
                if (userEntity != null) {
                    error.append("Tên đăng nhập này đã tồn tại!\n");
                }
            }
        }
        if (!ValidateUtil.checkNull(fullname)) {
            error.append("Bạn không được để trống tên đầy đủ!\n");
        }
        if (!ValidateUtil.checkNull(email)) {
            error.append("Bạn không được để trống email!\n");
        } else {
            if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
                error.append("Địa chỉ email không hợp lệ!\n");
            }
        }
        if (!ValidateUtil.checkNull(password)) {
            error.append("Bạn không được để trống mật khẩu!\n");
        }
        if (!ValidateUtil.checkNull(comfirmPassword)) {
            error.append("Bạn không được để trống nhập lại mật khẩu!\n");
        } else {
            if(!comfirmPassword.equals(password)){
                error.append("2 Mật khẩu phải nhập giống nhau!\n");
            }
        }
        if (error.toString().isEmpty()) {
            UserEntity userEntity = new UserEntity(username, password, fullname, email, 0);
            userService.insertUser(userEntity);
            return true;
        } else {
            req.setAttribute("username", username);
            req.setAttribute("fullname", fullname);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("comfirmPassword", comfirmPassword);
            req.setAttribute("messenge", error.toString());
            return false;
        }

    }
}
