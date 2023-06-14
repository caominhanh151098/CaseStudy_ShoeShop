package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.UserInfoDao;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.util.List;

public class User_infoService {

    private UserInfoDao user_infoDao = new UserInfoDao();
    public List<UserInfo> findAll(){
        return user_infoDao.findAll();
    }

    public UserInfo findById(int id){
        return user_infoDao.findById(id);
    }

    public void update(UserInfo userInfo){
        user_infoDao.updateUserInfo(userInfo);
    }

    public void create(UserInfo user_info){
        user_infoDao.insertUserInfo(user_info);
    }
}
