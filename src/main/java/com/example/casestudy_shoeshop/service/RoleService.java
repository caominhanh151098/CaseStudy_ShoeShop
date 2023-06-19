package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.RoleDao;
import com.example.casestudy_shoeshop.model.Role;

import java.util.List;

public class RoleService {
    private RoleDao roleDao = new RoleDao();
    public List<Role> findAll(){
        return roleDao.findAll();
    }

    public Role findById(int idRole){
       return roleDao.findById(idRole);
    }

    public Role findByName(String name){
        return roleDao.findByName(name);
    }

}
