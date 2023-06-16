package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.dao.OrderDetailDao;
import com.example.casestudy_shoeshop.dao.ProductDao;
import com.example.casestudy_shoeshop.dao.SizeDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.Size;

import java.util.List;

public class ShopService {
    private static ProductDao productDao = new ProductDao();
    private static SizeDao sizeDao = new SizeDao();
    private static CategoryDao categoryDao = new CategoryDao();
    private static OrderDetailDao orderDetailDao = new OrderDetailDao();

    public Product getProductById(int productId) {
        return productDao.findById(productId);
    }
    public List<OrderDetail> getCartByUserId(int userId) {
        return orderDetailDao.getCartByUserId(userId);
    }
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    public List<Product> getProducts(Pageable pageable) {
        String string = pageable.getPriceString();
//        String[] s = string.split("][");
        return productDao.findAll(pageable);
    }

    public Product findById(int id) {
        return productDao.findById(id);
    }

    public List<Size> findSizeByProductId(int id) {
        return sizeDao.getSizeByIdProduct(id);
    }
}
