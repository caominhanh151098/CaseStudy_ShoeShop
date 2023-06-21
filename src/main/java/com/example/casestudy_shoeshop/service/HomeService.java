package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.CategoryDao;
import com.example.casestudy_shoeshop.dao.OrderDao;
import com.example.casestudy_shoeshop.dao.OrderDetailDao;
import com.example.casestudy_shoeshop.dao.ProductDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.enums.Status;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

public class HomeService {
    private static CategoryDao categoryDao = new CategoryDao();
    private static ProductDao productDao = new ProductDao();
    private static OrderDao orderDao = new OrderDao();
    private static OrderDetailDao orderDetailDao = new OrderDetailDao();

    public List<Product> getAllProduct() {
        return productDao.getAllProducts();
    }

    public List<Product> getProducts() {
        Pageable pageable = new Pageable("", 1, 8, "id", "ASC");
        return productDao.findAll(pageable);
    }

    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    public Order getCartByUserId(int id) {
        return orderDao.findCartByUserId(id);
    }

    public Order getCartBySession(String sessionId) {
        return orderDao.findCartBySesionId(sessionId);
    }

    public void checkOrder(Order orderUser, Order orderSession, String sessionId) {
        if (orderUser != null) {
            if (orderSession != null) {
                if (orderUser.getId() != orderSession.getId()) {
                    for (OrderDetail orderDetail : orderSession.getOrderDetailList()) {
                        orderDetail.setOrderID(orderUser.getId());
                        orderDetailDao.updateOrderDetail(orderDetail);
                        orderUser.getOrderDetailList().add(orderDetail);
                    }
                    orderDao.dropOrder(orderSession.getId());
                }
            }
            orderUser.setSession_id(sessionId);
            orderDao.updateOrder(orderUser);
            orderDao.updateTPriceOrder(orderUser);
        } else if (orderSession != null) {
            orderSession.setUserId(orderUser.getUserId());
            orderDao.updateOrder(orderSession);
        }
    }
}
