package com.example.casestudy_shoeshop.ulti;

import java.util.regex.Pattern;

public class Regex {
    private static final String USERNAME_REGEX = "^[a-z][a-z0-9]{5,}$";
    public static boolean checkUsername(String username) {
        return Pattern.compile(USERNAME_REGEX).matcher(username).matches();
    }

    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9]{6,}$";
    public static boolean checkPassword(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    private static final String NAME_REGEX = "^[a-zA-ZÀ-Ỹà-ỹ ]+$";
    public static boolean checkName(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static boolean checkEmail(String email) {
        return Pattern.compile(USERNAME_REGEX).matcher(email).matches();
    }

    private static final String DATE_REGEX = "^(0?[1-9]|[12]\\d|3[01])[\\-](0?[1-9]|1[0-2])[\\-](19|20)\\d{2}$";
    public static boolean checkDate(String date) {
        return Pattern.compile(USERNAME_REGEX).matcher(date).matches();
    }

    private static final String PHONENUMBER_REGEX = "^[0]\\d{9}$";
    public static boolean checkPhone(String phone) {
        return Pattern.compile(USERNAME_REGEX).matcher(phone).matches();
    }
}
