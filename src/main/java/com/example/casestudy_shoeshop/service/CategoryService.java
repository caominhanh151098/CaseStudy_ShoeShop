package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.model.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDao categoryDao = new CategoryDao();

    public List<Category> findAll(){
        return categoryDao.findAll();
    }

    public Category findById (int id){
        return categoryDao.findById(id);
    }

}
