package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends ConnectionDatabase {

    private final String SELECT_CATEGORY = "SELECT * FROM category";

    private final String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE id = ?";


    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_CATEGORY))) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("category_name");
                String img = rs.getString("img");

                categories.add(new Category(id, name, img));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public Category findById(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_CATEGORY_BY_ID))) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCa = rs.getInt("id");
                String name = rs.getString("category_name");
                String img = rs.getString("img");

                return new Category(idCa, name, img);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
