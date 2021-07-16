package com.fpoly.service;

import com.fpoly.entity.UserEntity;
import com.fpoly.entity.VideoEntity;
import com.fpoly.service.impl.UserService;
import com.fpoly.service.impl.VideoService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Lab6Service {
    @Inject
    private UserService userService;

    @Inject
    private VideoService videoService;

    public void findVideoByUsername(HttpServletRequest req) {
        String username = req.getParameter("username");
        UserEntity user = new UserEntity();
        user = userService.findByUsername(username);
        if (user == null) {
            req.setAttribute("messenge", "Người dùng này không tồn tại!");
        } else {
            List<VideoEntity> listVideo = videoService.findByUser(user.getId());
            if (listVideo != null) {
                req.setAttribute("listVideo", listVideo);
            } else {
                req.setAttribute("messenge", "Người dùng chưa thích video nào!");
            }
        }
        req.setAttribute("username", username);
    }

    public void findVideoFavoritesByKeyword(HttpServletRequest req) {
        String keyword = req.getParameter("keyword");
        List<VideoEntity> listVideo = videoService.findVideoFavoritesByKeyword(keyword);
        if (listVideo == null) {
            req.setAttribute("messenge", "Không tìm thấy video được yêu thích nào có tiêu đề như vậy!");
        } else {
            req.setAttribute("listVideo", listVideo);
        }
        req.setAttribute("keyword", keyword);
    }

    public void findUserByVideo(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("videoid"));
        List<UserEntity> listUser = userService.findByVideo(id);
        if (listUser == null) {
            req.setAttribute("messenge", "Video này chưa được người dùng nào thích!");
        } else {
            req.setAttribute("listUser", listUser);
        }
        req.setAttribute("videoid", id);
    }

    public void filterVideo(HttpServletRequest req) {
        String type = req.getParameter("type");
        if (type != null && type.equals("favorite")) {
            List<VideoEntity> listVideo = videoService.findVideoFavorite();
            req.setAttribute("listVideo", listVideo);
            req.setAttribute("type", "favorite");
        } else if (type != null && type.equals("not-favorite")) {
            List<VideoEntity> listVideo = videoService.findVideoNotFavorite();
            req.setAttribute("listVideo", listVideo);
            req.setAttribute("type", "notfavorite");
        }
    }

    public void findVideoByDate(HttpServletRequest req) {
        try {
            String fromDate = req.getParameter("fromDate");
            String toDate = req.getParameter("toDate");
            if(fromDate.isEmpty() || toDate.isEmpty()){
                req.setAttribute("messenge", "Thời gian bạn chọn chưa chính xác!");
            } else {
                List<VideoEntity> listVideo = videoService.findVideoByDate(fromDate, toDate);
                if (listVideo == null) {
                    req.setAttribute("messenge", "Không tìm thấy video nào được thích trong khoảng thời gian này!");
                }
                req.setAttribute("listVideo", listVideo);
                req.setAttribute("fromDate", fromDate);
                req.setAttribute("toDate", toDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
