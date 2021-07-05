package com.fpoly.service;

import com.fpoly.model.Lab4Item;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Lab4Service {
    public static List<Lab4Item> listItems = new ArrayList<>();
    public String fillView(HttpServletRequest req) {
        String uri = req.getRequestURI();
        String view = "";
        if (uri.contains("items")) {
            if(listItems.size() == 0){
                showListItem(req);
            }
            req.setAttribute("listItem", listItems);
            view = "/views/lab4/listItem.jsp";
        } else if (uri.contains("user-management")) {
            view = "/views/lab4/userManagement.jsp";
        } else if(uri.contains("product-details")){
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("model", listItems.get(id-1));
            view = "/views/lab4/productDetails.jsp";
        }
        return view;
    }

    public void showListItem(HttpServletRequest req) {
        listItems.add(new Lab4Item(1,"Item 1","product.jpg",10,10,"Mô tả 1","17-07-2021"));
        listItems.add(new Lab4Item(2,"Item 2","product.jpg",20,20,"Mô tả 2","17-07-2021"));
        listItems.add(new Lab4Item(3,"Item 3","product.jpg",30,30,"Mô tả 3","17-07-2021"));
        listItems.add(new Lab4Item(4,"Item 4","product.jpg",40,40,"Mô tả 4","17-07-2021"));
        listItems.add(new Lab4Item(5,"Item 5","product.jpg",50,50,"Mô tả 5","17-07-2021"));
        listItems.add(new Lab4Item(6,"Item 6","product.jpg",60,60,"Mô tả 6","17-07-2021"));
        listItems.add(new Lab4Item(7,"Item 7","product.jpg",70,70,"Mô tả 7","17-07-2021"));
        listItems.add(new Lab4Item(8,"Item 8","product.jpg",80,80,"Mô tả 8","17-07-2021"));
    }

}
