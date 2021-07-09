package com.fpoly.utils;

public class ValidateUtil {
    public static boolean checkNull(String string){
        if(string.trim().length() == 0){
            return false;
        } else {
            return true;
        }
    }
}
