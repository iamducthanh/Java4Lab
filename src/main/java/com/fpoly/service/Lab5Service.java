package com.fpoly.service;

import com.fpoly.dao.impl.UserDao;
import com.fpoly.entity.UserEntity;
import com.fpoly.service.impl.UserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Lab5Service {
    @Inject
    private UserService userService;

    @Inject
    private UserDao userDao;

    public String fillView(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("test-jpa")) {
            view = "/views/lab5/testjpa.jsp";
        } else if (uri.contains("quan-li-user")) {
            List<UserEntity> listUser = userService.findAll();
            req.setAttribute("listUser", listUser);
            view = "/views/lab5/quanliuser.jsp";
        }
        return view;
    }

    public void addUser(HttpServletRequest req) {
        String username = req.getParameter("usernameInsert");
        String password = req.getParameter("passwordInsert");
        String fullname = req.getParameter("fullnameInsert");
        String email = req.getParameter("emailInsert");
        int role = Integer.parseInt(req.getParameter("roleInsert"));
        UserEntity userEntity = new UserEntity(username, password, fullname, email, role);
        userService.insertUser(userEntity);
    }

    public void updateUser(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        String username = req.getParameter("usernameUpdate");
        String password = req.getParameter("passwordUpdate");
        String fullname = req.getParameter("fullnameUpdate");
        String email = req.getParameter("emailUpdate");
        int role = Integer.parseInt(req.getParameter("roleUpdate"));
        UserEntity userEntity = userService.findById(id);
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setFullname(fullname);
        userEntity.setEmail(email);
        userEntity.setRole(role);
        userService.updateUser(userEntity);
    }

    public void deleteUser(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        userService.removeUser(id);
    }

    public void findAll(HttpServletRequest req) {
        StringBuilder ketqua = new StringBuilder();
        List<UserEntity> list = userService.findAll();
        list.forEach((user) -> {
            ketqua.append("username: " + user.getUsername() + ", password: " + user.getPassword() + "; ");
        });
        req.setAttribute("outFindAll", ketqua.toString());
    }

    public void findByRole(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("role"));
        StringBuilder ketqua = new StringBuilder();
        List<UserEntity> list = userService.findByRole(id);
        list.forEach((user) -> {
            ketqua.append("username: " + user.getUsername() + ", password: " + user.getPassword() + "; ");
        });
        req.setAttribute("outFindByRole", ketqua.toString());
    }

    public void findByKeyword(HttpServletRequest req) {
        String keyword = "%" + req.getParameter("keywork") + "%";
        StringBuilder ketqua = new StringBuilder();
        List<UserEntity> list = userService.findByKeyword(keyword);
        list.forEach((user) -> {
            ketqua.append("username: " + user.getUsername() + ", password: " + user.getPassword() + "; ");
        });
        req.setAttribute("outFindByKeyword", ketqua.toString());
    }

    public void findOne(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        StringBuilder ketqua = new StringBuilder();
        UserEntity user = userService.findByUsernameAndPassword(username, password);
        ketqua.append("username: " + user.getUsername() + ", password: " + user.getPassword());
        req.setAttribute("outFindOne", ketqua.toString());
    }

    public void findByPage(HttpServletRequest req){
        int page = Integer.parseInt(req.getParameter("page"));
        int max = Integer.parseInt(req.getParameter("max"));
        StringBuilder ketqua = new StringBuilder();
        List<UserEntity> list = userService.findByPage(page-1,max);
        list.forEach((user) -> {
            ketqua.append("username: " + user.getUsername() + ", password: " + user.getPassword() + "; ");
        });
        req.setAttribute("outFindByPage", ketqua.toString());
    }
}
