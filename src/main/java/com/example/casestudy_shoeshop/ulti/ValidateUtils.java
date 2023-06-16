package com.example.casestudy_shoeshop.ulti;

public class ValidateUtils {
    public static boolean isNameValid(String name){
        if(name.equals("")){
            return false;
        }
        return true;
    }
    public static boolean isEmailValid(String email){
        if(email.equals("")){
            return false;
        }
        return true;
    }
    public static boolean isPhoneValid(String phone){
        if(phone.equals("")){
            return false;
        }
        return true;
    }
}
