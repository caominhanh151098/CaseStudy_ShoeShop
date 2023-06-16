package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.UserDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> findALL(Pageable pageable){
        return  userDao.findAll(pageable);
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
        return userDao.findByUserName(userName);
    }

}

