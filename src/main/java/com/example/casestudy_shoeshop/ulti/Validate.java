package com.example.casestudy_shoeshop.ulti;

import com.example.casestudy_shoeshop.model.UserInfo;
import com.example.casestudy_shoeshop.service.ProductService;
import com.example.casestudy_shoeshop.service.UserInfoService;
import com.example.casestudy_shoeshop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Validate {
    ProductService productService = new ProductService();
    UserInfoService userInfoService = new UserInfoService();
    UserService userService = new UserService();

    public boolean checkEmpty(String name) {
        return !Objects.equals(name,"");
    }

    public boolean checkPrice(String price){
        try{
            double number = Double.parseDouble(String.valueOf(price));
            if(number > 0 )
                return true;
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public boolean checkNameProduct (String name){
        return productService.finByName(name) == null;
    }

    public boolean checkEmail(String email){
        return userInfoService.findByEmail(email) == null;
    }

    public boolean checkPhone(String phone){
        return userInfoService.findByPhone(phone) == null;
    }

    public boolean checkUserName(String userName){
        return userService.findByName(userName) == null;
    }
}
