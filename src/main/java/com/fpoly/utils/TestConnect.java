package com.fpoly.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnect {
//    public static void main(String[] args) {
//        try {
//            String DB_URL = "jdbc:mysql://localhost:3306/polyoe";
//            String USER_NAME = "root";
//            String PASSWORD = "";
////            String DB_URL = "jdbc:mysql://us-cdbr-east-04.cleardb.com:3306/heroku_458d0af2410d609?reconnect=true";
////            String USER_NAME = "b92b48bf4d123b";
////            String PASSWORD = "5a4e760e";
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            PreparedStatement ps = conn.prepareStatement("select * from users");
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getString(3));
//                System.out.println(resultSet.getString(4));
//            }
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
