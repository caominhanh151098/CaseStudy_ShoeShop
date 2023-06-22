package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.OrderDao;
import com.example.casestudy_shoeshop.dao.OrderDetailDao;
import com.example.casestudy_shoeshop.dao.ProductDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Product;

import java.util.List;

public class OrderService {
    private static ProductDao productDao = new ProductDao();
    private static OrderDao orderDao = new OrderDao();
    private static OrderDetailDao orderDetailDao = new OrderDetailDao();

    public List<Order> findAll(Pageable pageable) {
        return orderDao.getAllOrdered(pageable);
    }

    public Order getOrderByOrderId(int orderId) {
        return orderDao.getOrderByOrderId(orderId);
    }

    public List<OrderDetail> getDetailByOrderId(int orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProducts();
    }

    public void changeStatusOrder(int orderId, int statusIndex) {
        if (statusIndex >1 && statusIndex < 5)
        orderDao.updateStatus(orderId, statusIndex);
    }

    public void cancelOrder(int orderId) {
        orderDao.updateStatus(orderId, 5);
    }
}
