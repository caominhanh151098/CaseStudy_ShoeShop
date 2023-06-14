package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.OrderDao;
import com.example.casestudy_shoeshop.model.Order;

import java.util.List;

public class OrderService {
    private static OrderDao orderDao = new OrderDao();

    public List<Order> findAll() {
        return orderDao.getAllOrdered();
    }
}
