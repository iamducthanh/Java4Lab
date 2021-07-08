package com.fpoly.utils;

public class ValidateUtil {
    public static boolean checkNull(String string){
        if(string.isBlank()){
            return false;
        } else {
            return true;
        }
    }
}
