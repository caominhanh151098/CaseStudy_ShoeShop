package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao {
    private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/shoe_shop";
    private String jdbcUsername = "root";
    //                            password của mình
    private String jdbcPassword = "123456";

    public UserInfoDao() {
    }



    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private final String SELECT_USERS_INFO = "select * from user_info;";
    private final String INSERT_USERS_INFO = "INSERT INTO `shoe_shop`.`user_info` (`user_id`, `name`, `dob`, `email`,`phone`) VALUES (?,?,?,?,?);";
    private final String SELECT_USER_INFO_BY_ID = "SELECT * FROM user_info WHERE user_id = ?";
    public List<UserInfo> findAll() {
        List<UserInfo> user_infoList = new ArrayList<>();
        // Step 1: tạo 1 kết nối xuống db để gọi câu lệnh SELECT or UPDATE, Delete, vv
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USERS_INFO)) {
            System.out.println(preparedStatement);
            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                //(truyên vào tên cột)
                int user_id = rs.getInt("user_id");
                //(truyên vào tên cột)
                String name = rs.getString("name");
                //(truyên vào tên cột)
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                user_infoList.add(new UserInfo(user_id,name,dob,email,phone));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user_infoList;
    }

    public void insertUserInfo(UserInfo userInfo) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_INFO)) {
            preparedStatement.setInt(1,userInfo.getUser_id());
            preparedStatement.setString(2, userInfo.getName());
            preparedStatement.setDate(3, userInfo.getDob());
            preparedStatement.setString(4, userInfo.getEmail());
            preparedStatement.setString(5,userInfo.getPhone());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public UserInfo findById(int id) {
        try (Connection connection = getConnection();

             // Step 2: truyền câu lênh mình muốn chạy nằm ở trong này (SELECT_USERS)
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_INFO_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);

            // Step 3: tương đương vowis cái sét
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4:
            //kiểm tra còn data hay không. còn thì cứ lấy bằng câu lệnh ở dưới
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                return new UserInfo(user_id,name,dob,email,phone);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
