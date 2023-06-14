package com.example.casestudy_shoeshop.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private List<OrderDetail> orderDetailList;
    private double totalPrice;
    private Date orderDate;
    private Status status;
    private int deliveryId;

    public Order() {
    }

    public Order(int userId, List<OrderDetail> orderDetailList, double totalPrice, Date orderDate, Status status, int deliveryId) {
        this.userId = userId;
        this.orderDetailList = orderDetailList;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryId = deliveryId;
    }

    public Order(int id, int userId, List<OrderDetail> orderDetailList, double totalPrice, Date orderDate, Status status, int deliveryId) {
        this.id = id;
        this.userId = userId;
        this.orderDetailList = orderDetailList;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
        this.deliveryId = deliveryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }
}
