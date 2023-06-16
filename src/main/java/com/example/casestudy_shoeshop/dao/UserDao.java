package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.model.Role;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends ConnectionDatabase{
    private UserInfoDao userInfoDao = new UserInfoDao();

    private final String SELECT_USERS = "SELECT u.*, ui.*, r.* FROM user u join user_info ui on u.id = ui.user_id join role r on u.role_id = r.id;";
    private final String CREATE_USERS= "INSERT INTO user (username, password, role_id) VALUES (?,?,?);";

    private final String UPDATE_USER = "UPDATE `shoe_shop`.`user` SET `username` = ?, `password` = ?, `role_id` = ? WHERE (`id` = ?);";
    private final String SELECT_USER_BY_ID = "SELECT u.*, ui.* , r.* FROM User u join user_info ui on u.id = ui.user_id join role r on u.role_id = r.id WHERE u.id = ?;";
    private final String SELECT_USER_BY_USERNAME = "SELECT u.* FROM user u WHERE u.username = ?;";


//    private final String SELECT_USER_BY_USERNAME = "SELECT u.*, ui.* , r.* FROM User u join user_info ui on u.id = ui.user_id join role r on u.role_id = r.id WHERE u.username = ?;";
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USERS)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                int role_id = rs.getInt("role_id");
                String role_name = rs.getString("role_name");
                Role role = new Role(role_id,role_name);

                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                UserInfo userInfo = new UserInfo(user_id,name,dob,email,phone);

                users.add(new User(id,username,password,role , userInfo));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }


    public void createUser(User user) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USERS)) {



            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getId());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        User newUser = findByUserName(user.getUsername());


        UserInfo userInfo = new UserInfo(newUser.getId(), user.getUser_info().getName(), user.getUser_info().getDob(), user.getUser_info().getEmail(), user.getUser_info().getPhone());
        userInfoDao.insertUserInfo(userInfo);
    }

    public void updateUser(User user) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3,user.getRole().getId());
            preparedStatement.setInt(5,user.getId());
//                preparedStatement.setString(5, book.getCategory().getNamecategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User findById(int idUser) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_BY_ID);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, idUser);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                int role_id = rs.getInt("role_id");
                String role_name = rs.getString("role_name");
                Role role = new Role(role_id,role_name);

                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                UserInfo userInfo = new UserInfo(user_id,name,dob,email,phone);

                return new User(id,username,password,role,userInfo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public User findByUserName(String userName) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(SELECT_USER_BY_USERNAME);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");

                int role_id = rs.getInt("role_id");
                String role_name = rs.getString("role_name");
                Role role = new Role(role_id,role_name);

                int user_id = rs.getInt("user_id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                UserInfo userInfo = new UserInfo(user_id,name,dob,email,phone);

                return new User(id,username,password,role,userInfo);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
