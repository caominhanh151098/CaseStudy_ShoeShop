package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao extends ConnectionDatabase{

    private final String SELECT_USERS_INFO = "select * from user_info;";
    private final String INSERT_USERS_INFO = "INSERT INTO `shoe_shop`.`user_info` (`user_id`, `name`, `dob`, `email`,`phone`) VALUES (?,?,?,?,?);";
    private final String SELECT_USER_INFO_BY_ID = "SELECT * FROM user_info WHERE (`user_id` = ?);";

    private final String SELECT_USER_INFO_BY_EMAIL = "SELECT * FROM user_info WHERE (`email` = ?);";

    private final String SELECT_USER_INFO_BY_PHONE = "SELECT * FROM user_info WHERE (`phone` = ?);";
    private final String UPDATE_USER_INFO = "UPDATE `shoe_shop`.`user_info` SET `name` = ?, `dob` = ?, `email` = ?, `phone` = ? WHERE (`user_id` = ?);";

    public List<UserInfo> findAll() {
        List<UserInfo> user_infoList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USERS_INFO)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                user_infoList.add(new UserInfo(user_id,name,dob,email,phone, address));
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
            preparedStatement.setString(3, String.valueOf(userInfo.getDob()));
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
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_INFO_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
//                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                return new UserInfo(id,name,dob,email,phone, address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public UserInfo findByEmail(String email) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_INFO_BY_EMAIL);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
//                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                return new UserInfo(user_id,name,dob,email,phone, address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public UserInfo findByPhone(String phone) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_INFO_BY_PHONE);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, phone);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
//                String phone = rs.getString("phone");
                String address = rs.getString("address");

                return new UserInfo(user_id,name,dob,email,phone, address);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void editUserInfo(UserInfo userInfo) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_INFO)) {
            preparedStatement.setString(1, userInfo.getName());
            preparedStatement.setString(2, String.valueOf(userInfo.getDob()));
            preparedStatement.setString(3,userInfo.getEmail());
            preparedStatement.setString(4,userInfo.getPhone());
            preparedStatement.setInt(5,userInfo.getUser_id());
//                preparedStatement.setString(5, book.getCategory().getNamecategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
