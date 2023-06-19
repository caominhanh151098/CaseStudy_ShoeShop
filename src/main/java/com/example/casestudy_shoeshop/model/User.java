package com.example.casestudy_shoeshop.model;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private Role role;
    private String userAvatar;
    private UserInfo user_info;

    public User() {
    }

    public User(int id, String username, String password, Role role, UserInfo user_info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.user_info = user_info;
    }

    public User(String username, String password, Role role, UserInfo user_info) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.user_info = user_info;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }
}
