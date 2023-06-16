package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.UserDao;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> findALL(){
        return  userDao.findAll();
    }


    public void create(User user){
        userDao.createUser(user);
    }

    public void update(User user){
        userDao.updateUser(user);
    }

    public User findByID(int id){
        return  userDao.findById(id);
    }

    public User findByName(String userName){
        return userDao.findByName(userName);
    }

}

