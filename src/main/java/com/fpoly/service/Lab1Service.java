package com.fpoly.service;

import javax.servlet.http.HttpServletRequest;

public class Lab1Service {
    public String fillView(String type, HttpServletRequest req){
        String view = "";
        if(type.equals("helloservlet")){
            view = "/views/lab1/helloServlet.jsp";
        } else if(type.equals("hello")){
            view = "views/lab1/hello.jsp";
        } else if(type.equals("hinh-chu-nhat")){
            req.setAttribute("display", "none");
            view = "/views/lab1/hinhChuNhat.jsp";
        } else {
            view = "/views/trangchu.jsp";
        }
        System.out.println(view);
        return view;
    }
}
