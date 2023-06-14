package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.model.Category;

import java.util.List;

public class HomeService {
    private static CategoryDao categoryDao = new CategoryDao();

    public List<Category> getCategories() {
        return categoryDao.findAll();
    }
}
