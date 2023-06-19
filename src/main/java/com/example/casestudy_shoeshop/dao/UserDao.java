package com.example.casestudy_shoeshop.dao;

import com.example.casestudy_shoeshop.dto.Pageable;
import com.example.casestudy_shoeshop.model.Role;
import com.example.casestudy_shoeshop.model.User;
import com.example.casestudy_shoeshop.model.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends ConnectionDatabase{
    private UserInfoDao userInfoDao = new UserInfoDao();

    private final String SELECT_USERS = "SELECT u.*,ui.*,r.role_name  FROM user u left join user_info ui on u.id = ui.user_id left join role r on r.id = u.role_id where u.role_id not in(3) AND lower(u.username) like '%s' order by '%s' '%s' limit %d offset %d";
    private final String SELECT_USERS_CUSTOMER = "SELECT u.*,ui.*,r.role_name  FROM user u left join user_info ui on u.id = ui.user_id left join role r on r.id = u.role_id where u.role_id  in(3) AND lower(u.username) like '%s' order by '%s' '%s' limit %d offset %d";
    private final String CREATE_USERS= "INSERT INTO user (username, password, role_id) VALUES (?,?,?);";

    private final String UPDATE_USER = "UPDATE `shoe_shop`.`user` SET `username` = ?, `password` = ?, `role_id` = ? WHERE (`id` = ?);";
    private final String SELECT_USER_BY_ID = "SELECT u.*, ui.* , r.* FROM User u join user_info ui on u.id = ui.user_id join role r on u.role_id = r.id WHERE u.id = ?;";
    private final String SELECT_USER_BY_USERNAME = "SELECT u.*,r.role_name FROM user u left join role r on u.role_id = r.id where u.username = ?;";
    private final String TOTAL_USER = "SELECT count(1) as total FROM user where lower(user.username) like '%s' limit %d offset %d;";

//    private final String SELECT_USER_BY_USERNAME = "SELECT u.*, ui.* , r.* FROM User u join user_info ui on u.id = ui.user_id join role r on u.role_id = r.id WHERE u.username = ?;";

    public List<User> findAll(Pageable pageable) {
        List<User> users = new ArrayList<>();
        String search = pageable.getSearch();
        if (search == null) {
            search = "";
        }
        search = "%" + search + "%";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_USERS,search,
                             pageable.getNameField(),
                             pageable.getSortBy(),
                             pageable.getTotalItems(),
                             (pageable.getPage() -1) * pageable.getTotalItems())))
        {
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
            //lấy tổng số trang
            PreparedStatement totalProduct = connection.prepareStatement(TOTAL_USER);
            totalProduct.setString(1,search);
            totalProduct.setString(2,search);

            ResultSet total = totalProduct.executeQuery();

            while (total.next()){
                double totalProducts = total.getDouble("total");
                double totalItem = Double.parseDouble(pageable.getTotalItems()+"");
                int totalPage = (int) Math.ceil(totalProducts/totalItem);
                pageable.setTotalPage(totalPage);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }


    public List<User> findAllCustomer(Pageable pageable) {
        List<User> users = new ArrayList<>();
        String search = pageable.getSearch();
        if (search == null) {
            search = "";
        }
        search = "%" + search + "%";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement(String.format(SELECT_USERS_CUSTOMER,search,
                             pageable.getNameField(),
                             pageable.getSortBy(),
                             pageable.getTotalItems(),
                             (pageable.getPage() -1) * pageable.getTotalItems())))
        {
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
            //lấy tổng số trang
            PreparedStatement totalProduct = connection.prepareStatement(TOTAL_USER);
            totalProduct.setString(1,search);
            totalProduct.setString(2,search);

            ResultSet total = totalProduct.executeQuery();

            while (total.next()){
                double totalProducts = total.getDouble("total");
                double totalItem = Double.parseDouble(pageable.getTotalItems()+"");
                int totalPage = (int) Math.ceil(totalProducts/totalItem);
                pageable.setTotalPage(totalPage);
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
//        User newUser = findByUserName(user.getUsername());
//
//        UserInfo userInfo = new UserInfo(newUser.getId(), user.getUser_info().getName(), user.getUser_info().getDob(), user.getUser_info().getEmail(), user.getUser_info().getPhone());
//        userInfoDao.insertUserInfo(userInfo);
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
                String password = rs.getString("password");

                int role_id = rs.getInt("role_id");
                String role_name = rs.getString("role_name");
                Role role = new Role(role_id,role_name);
//
//                int user_id = rs.getInt("user_id");
//                String name = rs.getString("name");
//                Date dob = rs.getDate("dob");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//                UserInfo userInfo = new UserInfo(user_id,name,dob,email,phone);

                return new User(id,userName,password,role);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
