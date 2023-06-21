package com.example.casestudy_shoeshop.ulti;

import com.example.casestudy_shoeshop.model.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Validate {

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

}
