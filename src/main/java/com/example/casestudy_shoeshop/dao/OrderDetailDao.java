package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Delivery;
import com.example.casestudy_shoeshop.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao extends ConnectionDatabase {
    private List<OrderDetail> orderDetailList = new ArrayList<>();
    private final String SELECT_BY_ORDER_ID = "SELECT * FROM order_detail where order_id = ?";
    private final String INSERT_ORDER_DETAIL = "INSERT INTO `order_detail` (`order_id`, `product_id`, `size_id`, `quantity`, `product_name`, `price`) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_ORDER_DETAIL = "UPDATE `order_detail` " +
            "SET `order_id` = ?, `product_id` = ?, `size_id` = ?, `quantity` = ?, `product_name` = ?, `price` = ?" +
            "WHERE (`id` = ?);";
    private final String DROP_ORDER_DETAIL = "DELETE FROM `order_detail` WHERE (`id` = ?);";
    private final String DROP_BY_ORDER_ID = "DELETE FROM `order_detail` WHERE (`order_id` = ?);";

    public List<OrderDetail> findByOrderId(int orderId) {
        orderDetailList = new ArrayList<>();
        Delivery delivery = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ORDER_ID)) {
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productID = rs.getInt("product_id");
                int sizeID = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                orderDetailList.add(new OrderDetail(id, productID, sizeID, quantity, productName, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }

    public void insertOrderDetail(OrderDetail orderDetail) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAIL)) {
            preparedStatement.setInt(1, orderDetail.getOrderID());
            preparedStatement.setInt(2, orderDetail.getProductID());
            preparedStatement.setInt(3, orderDetail.getSizeID());
            preparedStatement.setInt(4, orderDetail.getQuantity());
            preparedStatement.setString(5, orderDetail.getProductName());
            preparedStatement.setDouble(6, orderDetail.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_DETAIL)) {
            preparedStatement.setInt(1, orderDetail.getOrderID());
            preparedStatement.setInt(2, orderDetail.getProductID());
            preparedStatement.setInt(3, orderDetail.getSizeID());
            preparedStatement.setInt(4, orderDetail.getQuantity());
            preparedStatement.setString(5, orderDetail.getProductName());
            preparedStatement.setDouble(6, orderDetail.getPrice());
            preparedStatement.setInt(7, orderDetail.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropOrderDetail(int orderDetailId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_ORDER_DETAIL)) {
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, orderDetailId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void dropByOrderId(int orderId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_BY_ORDER_ID)) {
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
