package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;
import com.example.casestudy_shoeshop.model.Size;
import com.example.casestudy_shoeshop.model.SizeProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeProductDao extends ConnectionDatabase{

    private final String INSERT_SIZEPRODUCT = "INSERT INTO size_product (product_id, size_id, quantity) VALUES (?, ?, ?)";

    private final String UPDATE_SIZEPRODUCT_BY_ID = "UPDATE size_product SET quantity = ? WHERE (product_id = ?) and (size_id = ?)";

    public void insert(SizeProduct sizeProduct) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIZEPRODUCT))
        {
            preparedStatement.setInt(1, sizeProduct.getProduct().getId());
            preparedStatement.setInt(2, sizeProduct.getSize().getId());
            preparedStatement.setInt(3,sizeProduct.getQuantity());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateById(SizeProduct sizeProduct){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIZEPRODUCT_BY_ID))
        {

            preparedStatement.setInt(1,sizeProduct.getQuantity());
            preparedStatement.setInt(5,sizeProduct.getProduct().getId());
            preparedStatement.setInt(6,sizeProduct.getSize().getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
