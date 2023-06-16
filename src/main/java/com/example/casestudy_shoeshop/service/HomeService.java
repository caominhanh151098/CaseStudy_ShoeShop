package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.dao.ProductDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;

import java.util.List;

public class HomeService {
    private static CategoryDao categoryDao = new CategoryDao();
    private static ProductDao productDao = new ProductDao();

    public List<Product> getAllProduct() {
        Pageable pageable = new Pageable("");
        return productDao.findAll(pageable);
    }
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }
}
