package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.UserDao;
import com.example.casestudy_shoeshop.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> findALL(){
        return  userDao.findAll();
    }


    public void create(User user){
        userDao.insertUser(user);
    }

    public void update(User user){
        userDao.updateUser(user);
    }

    public User findByID(int id){
        return  userDao.findById(id);
    }

}

