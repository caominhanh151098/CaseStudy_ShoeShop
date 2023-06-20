package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.UserInfoDao;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.util.List;

public class UserInfoService {

    private UserInfoDao user_infoDao = new UserInfoDao();
    public List<UserInfo> findAll(){
        return user_infoDao.findAll();
    }

    public void create(UserInfo user_info){
        user_infoDao.insertUserInfo(user_info);
    }

    public void editUserInfo(UserInfo userInfo){
        user_infoDao.editUserInfo(userInfo);
    }

    public UserInfo findById(int id){
        return user_infoDao.findById(id);
    }

    public UserInfo findByEmail(String email){
        return user_infoDao.findByEmail(email);
    }

    public UserInfo findByPhone(String phone){
        return user_infoDao.findByPhone(phone);
    }
}
