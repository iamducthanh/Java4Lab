package com.fpoly.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static SessionUtil sessionUtil = null;

    public static SessionUtil getSession(){
        if(sessionUtil == null){
            return sessionUtil = new SessionUtil();
        } else {
            return sessionUtil;
        }
    }

    public void putUser(HttpServletRequest req, String key, Object value){
        req.getSession().setAttribute(key, value);
    }

    public Object getUser(HttpServletRequest req, String key){
        return req.getSession().getAttribute(key);
    }

    public void removeUser(HttpServletRequest req, String key){
        req.getSession().removeAttribute(key);
    }

}
