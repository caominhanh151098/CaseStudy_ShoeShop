package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDao extends ConnectionDatabase {
    private final String SELECT_ALL = "SELECT * FROM delivery_point;";
    private final String SELECT_LAST_RECORD = "SELECT * FROM `delivery_point`" +
            "ORDER BY id DESC LIMIT 1";
    private final String SELECT_BY_ID = "SELECT * FROM delivery_point dp WHERE dp.id = ?;";
    private final String INSERT_DELIVERY = "INSERT INTO `delivery_point` (`customer_name`, `customer_email`, `customer_phone`, `customer_address`)" +
            "VALUES (?, ?, ?, ?)";
    private final String UPDATE_DELIVERY = "UPDATE `delivery_point` " +
            "SET `customer_name` = ?, `customer_email` = ?, `customer_phone` = ?, `customer_adress` = ? WHERE (`id` = ?);";

    private static List<Delivery> deliveryList = new ArrayList<>();

    public List<Delivery> getAll() {
        List<Delivery> deliveryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String customer_name = rs.getString("customer_name");
                String customer_email = rs.getString("customer_email");
                String customer_phone = rs.getString("customer_phone");
                String customer_address = rs.getString("customer_address");
                Delivery delivery = new Delivery(id, customer_name, customer_email, customer_phone, customer_address);
                deliveryList.add(delivery);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deliveryList;
    }

    public Delivery findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String customer_name = rs.getString("customer_name");
                String customer_email = rs.getString("customer_email");
                String customer_phone = rs.getString("customer_phone");
                String customer_address = rs.getString("customer_address");
                return new Delivery(id, customer_name, customer_email, customer_phone, customer_address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Delivery insertDelivery(Delivery delivery) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DELIVERY)) {
            preparedStatement.setString(1, delivery.getCustomer_name());
            preparedStatement.setString(2, delivery.getCustomer_email());
            preparedStatement.setString(3, delivery.getCustomer_phone());
            preparedStatement.setString(4, delivery.getCustomer_address());
            preparedStatement.executeUpdate();
            PreparedStatement preStatement = connection.prepareStatement(SELECT_LAST_RECORD);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                delivery.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delivery;
    }

    public void updateDelivery(Delivery delivery) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DELIVERY)) {
            preparedStatement.setString(1, delivery.getCustomer_name());
            preparedStatement.setString(2, delivery.getCustomer_email());
            preparedStatement.setString(3, delivery.getCustomer_phone());
            preparedStatement.setString(4, delivery.getCustomer_address());
            preparedStatement.setInt(5, delivery.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
