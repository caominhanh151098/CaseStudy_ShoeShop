package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.OrderDetailDao;
import com.example.casestudy_shoeshop.model.OrderDetail;

import java.util.List;

public class OrderDetailService {
    private OrderDetailDao orderDetailDao = new OrderDetailDao();

    public List<OrderDetail> orderDetailList (int orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

    public void createOrderDetail (OrderDetail orderDetail) {
        orderDetailDao.insertOrderDetail(orderDetail);
    }

    public void editOrderDetail (OrderDetail orderDetail) {
        orderDetailDao.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail (int id) {
        orderDetailDao.dropOrderDetail(id);
    }

    public void deleteAll (int orderId) {
        orderDetailDao.dropByOrderId(orderId);
    }
}
