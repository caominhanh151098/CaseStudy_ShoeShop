package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao extends ConnectionDatabase{
    private final String SELECT_ROLE = "select * from role;";
    public final String SELECT_ROLE_BY_ID = " select * from role where id = ?;";
    public final String SELECT_ROLE_BY_NAME = " select * from role where role_name = ?;";
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_ROLE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String role_name = rs.getString("role_name");
                roles.add(new Role(id,role_name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return roles;
    }

    public Role findById(int idRole) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_ROLE_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, idRole);

            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                //(truyên vào tên cột)
                int id = rs.getInt("id");
                //(truyên vào tên cột)
                String role_name = rs.getString("role_name");
                //(truyên vào tên cột)
                return new Role(id, role_name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Role findByName(String name) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_ROLE_BY_NAME);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, name);


            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String role_name = rs.getString("role_name");
                return new Role(id, role_name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
