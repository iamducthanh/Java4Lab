package com.fpoly.controller;

import com.fpoly.entity.Report;
import com.fpoly.service.IReportService;
import com.fpoly.service.Lab6Service;

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

@WebServlet(urlPatterns = {
        "/lab6/find-favorites-by-username",
        "/lab6/find-video-by-favotites",
        "/lab6/find-user-by-video",
        "/lab6/filer-video",
        "/lab6/report",
        "/lab6/find-Video-By-Date",
        "/lab6/find-Video-By-Month"
})
public class Lab6Controller extends HttpServlet {
    @Inject
    private Lab6Service lab6Service;

    @Inject
    private IReportService reportService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "";
        String uri = req.getRequestURI();
        if(uri.contains("/lab6/find-favorites-by-username")){
            view = "/views/lab6/findFavorites.jsp";
        } else if(uri.contains("/lab6/find-video-by-favotites")){
            view = "/views/lab6/fillVideo.jsp";
        } else if(uri.contains("/lab6/find-user-by-video")){
            view = "/views/lab6/fillUser.jsp";
        } else if(uri.contains("/lab6/filer-video")){
            lab6Service.filterVideo(req);
            view = "/views/lab6/filterVideo.jsp";
        } else if(uri.contains("/lab6/report")){
            List<Report> list = reportService.getListReport();
            req.setAttribute("listReport", list);
            view = "/views/lab6/thongke.jsp";
        } else if(uri.contains("/lab6/find-Video-By-Date")){
            view = "/views/lab6/findVideoByDate.jsp";
        } else if(uri.contains("/lab6/find-Video-By-Month")){
            view = "/views/lab6/findVideoByMonth.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "";
        String uri = req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if(uri.contains("/lab6/find-favorites-by-username")){
            lab6Service.findVideoByUsername(req);
            view = "/views/lab6/findFavorites.jsp";
        } else if(uri.contains("/lab6/find-video-by-favotites")){
            lab6Service.findVideoFavoritesByKeyword(req);
            view = "/views/lab6/fillVideo.jsp";
        } else if(uri.contains("/lab6/find-user-by-video")){
            lab6Service.findUserByVideo(req);
            view = "/views/lab6/fillUser.jsp";
        } else if(uri.contains("/lab6/find-Video-By-Date")){
            lab6Service.findVideoByDate(req);
            view = "/views/lab6/findVideoByDate.jsp";
        } else if(uri.contains("/lab6/find-Video-By-Month")){
            String[] months = req.getParameterValues("month");
            List<Integer> listMonth = new ArrayList<>();
            if(months != null){
                for(String month: months) {
                    System.out.println(month);
                    req.setAttribute("checkBox"+month, month);
                    listMonth.add(Integer.parseInt(month));
                }
            }
            view = "/views/lab6/findVideoByMonth.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }
}
