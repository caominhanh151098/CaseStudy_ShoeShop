package com.example.casestudy_shoeshop.ulti;

import com.example.casestudy_shoeshop.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Validate {
    List<String> errors = new ArrayList<>();
    UserInfo userInfo = new UserInfo();

//    private void validateName(HttpServletRequest req, List<String> errors, UserInfo userInfo) {
//        String name = req.getParameter("name");
//        if(!ValidateUtils.isNameValid(name)){
//            errors.add("Ten khong duoc de trong");
//        }
//        userInfo.setName(name);
//    }
}
