package com.example.casestudy_shoeshop.service;

import com.example.casestudy_shoeshop.dao.*;
import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.*;
import com.example.casestudy_shoeshop.model.enums.Status;

import java.util.Date;
import java.util.List;

public class ShopService {
    private static UserDao userDao = new UserDao();
    private static ProductDao productDao = new ProductDao();
    private static SizeDao sizeDao = new SizeDao();
    private static CategoryDao categoryDao = new CategoryDao();
    private static OrderDetailDao orderDetailDao = new OrderDetailDao();
    private static OrderDao orderDao = new OrderDao();
    private static DeliveryDao deliveryDao = new DeliveryDao();

    public User findUserById(int userId) {
        return userDao.findById(userId);
    }

    public Product getProductById(int productId) {
        return productDao.findById(productId);
    }

    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    public List<Product> getProducts(Pageable pageable) {
        return productDao.findAll(pageable);
    }

    public List<Size> findSizeByProductId(int id) {
        return sizeDao.getSizeByIdProduct(id);
    }


    public Order findCartByUserId(int userId) {
        return orderDao.findCartByUserId(userId);
    }

    public void updateCartDetail(int idCartDetail, int quantity) {
        OrderDetail cartDetail = orderDetailDao.findByODId(idCartDetail);
        cartDetail.setQuantity(quantity);
        orderDetailDao.updateOrderDetail(cartDetail);
    }

    public void updateCart(int userId) {
        Order cartUser = orderDao.findCartByUserId(userId);
        orderDao.updateTPriceOrder(cartUser);
    }

    public void acceptOrder(Order cartUser, Delivery delivery) {
        cartUser.setStatus(Status.valueOf("Ordered"));
        cartUser.setOrderDate(new Date());
        deliveryDao.insertDelivery(delivery);
        cartUser.setDelivery(delivery);
        orderDao.updateOrder(cartUser);
    }

    public void removeCartDetail(int userID, int idCartDetail) {
        orderDetailDao.dropOrderDetail(idCartDetail);
        Order cartUser = orderDao.findCartByUserId(userID);
        orderDao.updateTPriceOrder(cartUser);
    }

    public void addToCart(int userId, OrderDetail cartDetail) {
        Order cartUser = orderDao.findCartByUserId(userId);
        Product product = productDao.findById(cartDetail.getProductID());
        cartDetail.setProductName(product.getProduct_name());
        cartDetail.setPrice(product.getPrice());

        if (cartUser == null) {
            cartUser = new Order(userId, Status.valueOf("Shopping"));
            orderDao.insertOrder(cartUser);
            cartDetail.setOrderID(cartUser.getId());

            orderDetailDao.insertOrderDetail(cartDetail);
        }
        else {
            cartDetail.setOrderID(cartUser.getId());
            orderDetailDao.insertOrderDetail(cartDetail);
        }
        cartUser.getOrderDetailList().add(cartDetail);
        orderDao.updateTPriceOrder(cartUser);
    }
}
