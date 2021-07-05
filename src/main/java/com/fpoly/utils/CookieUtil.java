package com.fpoly.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static CookieUtil cookieUtil = null;

    public static CookieUtil getCookieUtil(){
        if(cookieUtil == null){
            return cookieUtil = new CookieUtil();
        } else {
            return cookieUtil;
        }
    }

    public static Cookie add(String name, String value, int hours, HttpServletResponse resp) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours);
        cookie.setPath("/");
        resp.addCookie(cookie);
        return cookie;
    }

    public static String get(String name, HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equalsIgnoreCase(name)){
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
}
