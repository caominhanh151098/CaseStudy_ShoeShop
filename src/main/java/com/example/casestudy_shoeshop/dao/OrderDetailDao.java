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
    private final String SELECT_BY_ID = "SELECT * FROM order_detail where id = ?";
    private final String SELECT_CARTLIST_BY_ID = "SELECT od.* " +
            "FROM `order` o JOIN order_detail od ON od.order_id = o.id " +
            "where order_id = ?";
    private final String INSERT_ORDER_DETAIL = "INSERT INTO `order_detail` (`order_id`, `product_id`, `size_id`, `quantity`, `product_name`, `price`) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_ORDER_DETAIL = "UPDATE `order_detail` SET `quantity` = ? WHERE (`id` = ?);";
    private final String DROP_ORDER_DETAIL = "DELETE FROM `order_detail` WHERE (`id` = ?);";
    private final String DROP_BY_ORDER_ID = "DELETE FROM `order_detail` WHERE (`order_id` = ?);";

    public List<OrderDetail> findByOrderId(int orderId) {
        orderDetailList = new ArrayList<>();
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
                orderDetailList.add(new OrderDetail(id, orderId, productID, sizeID, quantity, productName, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }

    public OrderDetail findByODId(int oDId) {
        orderDetailList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, oDId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int productID = rs.getInt("product_id");
                int sizeID = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                return new OrderDetail(oDId, orderId, productID, sizeID, quantity, productName, price);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void insertOrderDetail(OrderDetail orderDetail) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement1 = connection.prepareStatement(INSERT_ORDER_DETAIL);
            preStatement1.setInt(1, orderDetail.getOrderID());
            preStatement1.setInt(2, orderDetail.getProductID());
            preStatement1.setInt(3, orderDetail.getSizeID());
            preStatement1.setInt(4, orderDetail.getQuantity());
            preStatement1.setString(5, orderDetail.getProductName());
            preStatement1.setDouble(6, orderDetail.getPrice());
            preStatement1.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_DETAIL)) {
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setInt(2, orderDetail.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropOrderDetail(int orderDetailId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DROP_ORDER_DETAIL)) {
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

    public List<OrderDetail> getCartListByOrderId(int orderId) {
        orderDetailList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARTLIST_BY_ID)) {
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int productID = rs.getInt("product_id");
                int sizeID = rs.getInt("size_id");
                int quantity = rs.getInt("quantity");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                orderDetailList.add(new OrderDetail(id, orderId, productID, sizeID, quantity, productName, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailList;
    }
}
