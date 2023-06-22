package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.OrderDao;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Order;

import java.util.List;

public class CancelOrderService {
    private static OrderDao orderDao = new OrderDao();

    public List<Order> getCancelOrders(Pageable pageable) {
        return orderDao.getCancelOrders(pageable);
    }
}
