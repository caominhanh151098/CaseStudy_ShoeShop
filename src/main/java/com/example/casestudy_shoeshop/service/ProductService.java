package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.ProductDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Product;

import java.util.List;

public class ProductService {
   private final ProductDao productDao = new ProductDao();

    public List<Product> findAll(Pageable pageable){
        return productDao.findAll(pageable);
    }
    public void insert(Product product){
         productDao.insert(product);
    }

    public Product findById(int id){
        return productDao.findById(id);
    }

    public void update(Product product){
        productDao.update(product);
    }

    public Product finByName(String name){
        return productDao.findByName(name);
    }
}
