package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDao extends ConnectionDatabase{
    private final String SELECT_SIZE = "SELECT * FROM size_product";

    public List<Size> findAll() {
        List<Size> sizes = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_SIZE)))
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int size = rs.getInt("size");

                sizes.add(new Size(id,size));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sizes;
    }
}