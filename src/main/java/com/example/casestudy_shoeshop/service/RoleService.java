package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.RoleDao;
import com.example.casestudy_shoeshop.model.Role;

import java.util.List;

public class RoleService {
    private RoleDao roleDao = new RoleDao();
    public List<Role> findAll(){
        return roleDao.findAll();
    }

    public void findById(int idRole){
        roleDao.findById(idRole);
    }

}
