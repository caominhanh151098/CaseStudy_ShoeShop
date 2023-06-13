package com.example.casestudy_shoeshop.model;

public class OrderDetail {
    private int id;
    private int orderID;
    private int productID;
    private int sizeID;
    private int quantity;
    private String productName;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderID, int productID, int sizeID, int quantity, String productName, double price) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.sizeID = sizeID;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public OrderDetail(int orderID, int productID, int sizeID, int quantity, String productName, double price) {
        this.orderID = orderID;
        this.productID = productID;
        this.sizeID = sizeID;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
