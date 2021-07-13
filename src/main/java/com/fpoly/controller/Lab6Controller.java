package com.fpoly.controller;

import com.fpoly.entity.FavoritesEntity;
import com.fpoly.entity.UserEntity;
import com.fpoly.entity.VideoEntity;
import com.fpoly.service.impl.UserService;
import com.fpoly.service.impl.VideoService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/lab6/find-favorites-by-username"})
public class Lab6Controller extends HttpServlet {
    @Inject
    private UserService userService;

    @Inject
    private VideoService videoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "";
        String uri = req.getRequestURI();
        if(uri.contains("/lab6/find-favorites-by-username")){
            view = "/views/lab6/findFavorites.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "";
        String uri = req.getRequestURI();
        if(uri.contains("/lab6/find-favorites-by-username")){
            String username = req.getParameter("username");
            UserEntity user = new UserEntity();
            user = userService.findByUsername(username);
            if(user == null){
                req.setAttribute("messenge","Người dùng này không tồn tại!");
                req.setAttribute("username",username);
            } else {
                List<VideoEntity> listVideo = videoService.findByUser(user.getId());
                if(!listVideo.isEmpty()){
                    req.setAttribute("username",username);
                    req.setAttribute("listVideo",listVideo);
                    listVideo.forEach((fa)->{
                        System.out.println(fa.toString());
                    });
                } else {
                    req.setAttribute("messenge","Người dùng chưa thích video nào!");
                    req.setAttribute("username",username);
                }
            }
            view = "/views/lab6/findFavorites.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
