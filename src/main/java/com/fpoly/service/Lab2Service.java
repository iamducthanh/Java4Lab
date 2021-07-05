package com.fpoly.service;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

public class Lab2Service {
    ResourceBundle rb = ResourceBundle.getBundle("messenge");

    public String fillView(String uri, HttpServletRequest req){
        String view = "";
        if (uri.contains("tam-giac")) {
            req.setAttribute("display", "none");
            view = "/views/lab2/hinhTamGiac.jsp";
        } else if (uri.contains("dang-ki")) {
            view = "/views/lab2/dangKi.jsp";
        } else if(uri.contains("signup")){
            view = "/views/lab2/dangKi1.jsp";
        }
        return view;
    }

    public void tamGiac(HttpServletRequest req, String action){
        String aString = req.getParameter("canha");
        String bString = req.getParameter("canhb");
        String cString = req.getParameter("canhc");
        try {
            Double a = Double.parseDouble(aString);
            Double b = Double.parseDouble(bString);
            Double c = Double.parseDouble(cString);
            if ((a + b > c) && (a + c > b) && (c + b > a)) {
                req.setAttribute("display", "none");
                if (action.equals("chu-vi")) {
                    double chuVi = a + b + c;
                    req.setAttribute("ketQua", "Chu vi của tam giác: " + chuVi);
                } else if (action.equals("dien-tich")) {
                    double chuVi = a + b + c;
                    double dienTich = Math.sqrt(chuVi * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
                    System.out.println(dienTich);
                    req.setAttribute("ketQua", "Diện tích của tam giác: " + Double.valueOf(Math.round(dienTich * 100)) / 100);
                }
            } else {
                req.setAttribute("display", "unset");
                req.setAttribute("messenge", rb.getString("tamGiacFalse"));
            }
        } catch (Exception e){
            req.setAttribute("display", "unset");
            req.setAttribute("messenge", rb.getString("numberFalse"));
        }
        req.setAttribute("canha", aString);
        req.setAttribute("canhb", bString);
        req.setAttribute("canhc", cString);
    }

    public void dangKi(HttpServletRequest req){
        String[] soThich = req.getParameterValues("soThich");
        StringBuilder hobbyList = new StringBuilder();
        if(soThich != null){
            for (String hobby : soThich) {
                hobbyList.append(hobby + ", ");
            }
        }
        String honNhan;
        if(req.getParameter("honNhan") == null){
            honNhan = "Chưa kết hôn";
        } else {
            honNhan = "đã kết hôn";
        }
        req.setAttribute("username",req.getParameter("username"));
        req.setAttribute("password",req.getParameter("password"));
        req.setAttribute("gioiTinh",req.getParameter("gioiTinh"));
        req.setAttribute("quocTich",req.getParameter("quocTich"));
        req.setAttribute("soThich",hobbyList.toString());
        req.setAttribute("honNhan",honNhan);
        req.setAttribute("ghiChu",req.getParameter("note"));
    }

    public void dangKi1(HttpServletRequest req){
        String honNhan;
        if(req.getParameter("honNhan") == null){
            honNhan = "Chưa kết hôn";
        } else {
            honNhan = "đã kết hôn";
        }
        req.setAttribute("username",req.getParameter("username"));
        req.setAttribute("password",req.getParameter("password"));
        req.setAttribute("gioiTinh",req.getParameter("gioiTinh"));
        req.setAttribute("quocTich",req.getParameter("quocTich"));
        req.setAttribute("honNhan",honNhan);
        req.setAttribute("ghiChu",req.getParameter("note"));
    }
}
