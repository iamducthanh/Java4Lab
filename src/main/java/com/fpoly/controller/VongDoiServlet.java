package com.fpoly.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@WebServlet(urlPatterns = {"/lab2/bai4"})
public class VongDoiServlet extends HttpServlet {
    int count;
    String path = "D:\\Java\\count.txt";

    @Override
    public void init() throws ServletException {
        File file = new File(path);
        try {
            if(!file.exists()){
                file.createNewFile();
                count = 0;
            } else {
                count = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(0));
            }
        } catch (Exception e){

        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count ++;
        req.setAttribute("count", count);
        req.getRequestDispatcher("/views/lab2/count.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        try {
            Files.write(Paths.get(path), String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (Exception e){

        }
    }
}
