package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Delivery;
import com.example.casestudy_shoeshop.model.Order;
import com.example.casestudy_shoeshop.model.OrderDetail;
import com.example.casestudy_shoeshop.model.enums.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao extends ConnectionDatabase {
    private final String SELECT_ALL_ORDERED = "SELECT o.*, ui.`name` as `name_user` " +
            "FROM user u JOIN `order` o ON u.id = o.user_id JOIN user_info ui ON u.id = ui.user_id " +
            "WHERE o.status <> 1";
    private final String SELECT_ORDER_BY_USER_ID = "SELECT o.*, ui.`name` as `name_user` " +
            "FROM user u JOIN `order` o ON u.id = o.user_id " +
            "JOIN user_info ui ON u.id = ui.user_id WHERE o.user_id = ? AND status <> 1";
    private final String SELECT_CART_BY_USER_ID = "SELECT o.*, ui.`name` as `name_user` " +
            "FROM user u JOIN `order` o ON u.id = o.user_id " +
            "JOIN user_info ui ON u.id = ui.user_id WHERE o.user_id = ? AND status = 1";

    private final String SELECT_CART_BY_SESSION = "SELECT o.* FROM `order` o WHERE session_id like ? AND `status` = 'Shopping'";
    private final String SELECT_CART_BY_ID = "SELECT * FROM `order` o  WHERE id = ?";
    private final String SELECT_LAST_RECORD = "SELECT * FROM `order` ORDER BY id DESC LIMIT 1";
    private final String INSERT_ORDER = "INSERT INTO `order` (`user_id`, `status`) " +
            "VALUES (?, ?);";
    private final String CREATE_ORDER = "INSERT INTO `order` (`status`, `session_id`) VALUES (?,?);";
    private final String REMOVE_ORDER = "DELETE FROM `order` WHERE (`user_id` is null AND `status` = 'Shopping');";
    private final String UPDATE_ORDER = "UPDATE `order` SET `total_price` = ?, `order_date` = ?, `status` = ?, `delivery_id` = ? WHERE (`id` = ?);";
    private final String UPDATE_TOTAL_PRICE = "UPDATE `order` SET `total_price` = ? WHERE (`id` = ?);";
    private final String UPDATE_STATUS_ORDER = "UPDATE `order` SET `status` = ? WHERE (`id` = ?);";
    private OrderDetailDao orderDetailDao = new OrderDetailDao();
    private DeliveryDao deliveryDao = new DeliveryDao();
    private List<Order> orderList = new ArrayList<>();

    public List<Order> getAllOrdered() {
        orderList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERED)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String nameUser = rs.getString("name_user");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(id);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = rs.getDate("order_date");
                Status status = Status.valueOf(rs.getString("Status"));
                int deliveryId = rs.getInt("delivery_id");
                Delivery delivery = new Delivery();
                if (deliveryId != 0)
                    delivery = deliveryDao.findById(deliveryId);
                orderList.add(new Order(id, userId, nameUser, orderDetailList, totalPrice, orderDate, status, delivery));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    public List<Order> findByUserId(int userId) {
        orderList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameUser = rs.getString("name_user");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(id);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = rs.getDate("order_date");
                Status status = Status.valueOf(rs.getString("Status"));
                int deliveryId = rs.getInt("delivery_id");
                Delivery delivery = new Delivery();
                if (deliveryId != 0)
                    delivery = deliveryDao.findById(deliveryId);
                orderList.add(new Order(id, userId, nameUser, orderDetailList, totalPrice, orderDate, status, delivery));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    public Order findCartByUserId(int userId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nameUser = rs.getString("name_user");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(id);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = rs.getDate("order_date");
                Status status = Status.valueOf(rs.getString("Status"));

                return new Order(id, userId, nameUser, orderDetailList, totalPrice, orderDate, status, new Delivery());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Order findCartById(int orderId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_ID)) {
            preparedStatement.setInt(1, orderId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
                double totalPrice = rs.getDouble("total_price");
                Date orderDate = rs.getDate("order_date");
                Status status = Status.valueOf(rs.getString("Status"));

                return new Order(orderId, userId, "", orderDetailList, totalPrice, orderDate, status, new Delivery());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Order findCartBySesionId(String sessionId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_SESSION)) {
            preparedStatement.setString(1, sessionId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
                double totalPrice = rs.getDouble("total_price");
                Status status = Status.valueOf(rs.getString("Status"));

                return new Order(orderId, userId, orderDetailList, totalPrice, status, sessionId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void insertOrder(Order order) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER)) {
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setInt(2, order.getStatus().getIndex());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_LAST_RECORD);
            ResultSet rs = preparedStatement1.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                order.setId(idOrder);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Order createOrder(Order order) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_ORDER)) {
            preparedStatement.setInt(1, order.getStatus().getIndex());
            preparedStatement.setString(2, order.getSession_id());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_LAST_RECORD);
            ResultSet rs = preparedStatement1.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                order.setId(idOrder);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }

    public Order createNewOrder() {
        Order newOrder = new Order();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_ORDER);
            preparedStatement.executeUpdate();
            createOrder(newOrder);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newOrder;
    }

    public void updateOrder(Order order) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER)) {
            preparedStatement.setDouble(1, order.getTotalPrice());
            preparedStatement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            preparedStatement.setInt(3, order.getStatus().getIndex());
            preparedStatement.setInt(4, order.getDelivery().getId());
            preparedStatement.setInt(5, order.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTotalPrice(Order order) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOTAL_PRICE)) {
            preparedStatement.setDouble(1, order.getTotalPrice());
            preparedStatement.setInt(2, order.getId());
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

    public void updateTPriceOrder(Order cartUser) {
        double totalPrice = 0;
        for (OrderDetail orderDetail : cartUser.getOrderDetailList()) {
            totalPrice += orderDetail.getPrice() * orderDetail.getQuantity();
        }
        cartUser.setTotalPrice(totalPrice);
        updateTotalPrice(cartUser);
    }
}
