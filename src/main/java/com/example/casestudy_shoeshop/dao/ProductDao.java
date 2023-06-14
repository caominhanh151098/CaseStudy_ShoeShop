package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Category;
import com.example.casestudy_shoeshop.model.Product;
//import javafx.scene.image.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends ConnectionDatabase{
    private final String SELECT_PRODUCT = "SELECT p.* , c.category_name as categoryName FROM product p Left join category c on p.category_id = c.id";

    private final String INSERT_PRODUCT = "INSERT INTO product (product_name, price, description, img, category_id) VALUES (?, ?, ?, ?, ?)";

    private final String SELECT_PRODUCT_BY_ID = "SELECT p.* , c.category_name as categoryName\n" +
            "FROM product p\n" +
            " join category c on p.category_id = c.id\n" +
            "Where p.id = ?";


    private final String UPDATE_PRODUCT = "UPDATE product SET product_name = ?, price = ?, description = ?, img = ?, category_id = ? WHERE (id = ?)";

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
//        String search = search1.getSearch();
//        if(search == null){
//            search = "";
//        }
//        search = "%" + search + "%";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_PRODUCT)))
        {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("img");


                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("categoryName");
                Category category = new Category(categoryId,categoryName);

                products.add(new Product(id,name,price,description,image,category));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product findById(int id) {
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
        )
        {

            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idPr = rs.getInt("id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("img");


                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("categoryName");
                Category category = new Category(categoryId,categoryName);

                return new Product(idPr,name,price,description,image,category);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insert(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT))
        {
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4,product.getImage());
            preparedStatement.setInt(5,product.getCategory().getId());


            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Product product){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT))
        {

            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2, Double.parseDouble(String.valueOf(product.getPrice())));
            preparedStatement.setString(3, String.valueOf(product.getDescription()));
            preparedStatement.setString(4,product.getImage());
            preparedStatement.setInt(5,product.getCategory().getId());
            preparedStatement.setInt(6,product.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
