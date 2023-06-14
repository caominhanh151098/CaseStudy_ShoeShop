package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Delivery;
import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao extends ConnectionDatabase {
    private final String SELECT_ALL = "SELECT * FROM order;";
    private final String SELECT_BY_USER_ID = "SELECT * FROM order WHERE user_id = ?;";
    private final String INSERT_ORDER = "INSERT INTO `order` (`user_id`, `total_price`, `order_date`, `status`, `delivery_id`) VALUES (?, ?, ?, ?, ?);";
    private final String UPDATE_STATUS_ORDER = "UPDATE `order` SET `status` = ? WHERE (`id` = ?);";
    private OrderDetailDao orderDetailDao = new OrderDetailDao();
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getAll() {
        orderList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(id);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("order_date")) ;
                Status status = Status.valueOf(rs.getString("Status"));
                int deliveryId = rs.getInt("delivery_id");
                orderList.add(new Order(id,userId,orderDetailList,totalPrice,orderDate,status,deliveryId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("Lỗi Parse!");
        }
        return orderList;
    }

    public List<Order> findByUserId(int userId) {
        orderList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(id);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("order_date")) ;
                Status status = Status.valueOf(rs.getString("Status"));
                int deliveryId = rs.getInt("delivery_id");
                orderList.add(new Order(id,userId,orderDetailList,totalPrice,orderDate,status,deliveryId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("Lỗi Parse!");
        }
        return orderList;
    }

    public void insertOrder(Order order) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {
            preparedStatement.setInt(1, order.getId());
            preparedStatement.setDouble(2, order.getTotalPrice());
            preparedStatement.setDate(3, (java.sql.Date) order.getOrderDate());
            preparedStatement.setInt(4, order.getStatus().getIndex());
            preparedStatement.setInt(5, order.getDeliveryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatus(int orderId, int status) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS_ORDER)) {
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
