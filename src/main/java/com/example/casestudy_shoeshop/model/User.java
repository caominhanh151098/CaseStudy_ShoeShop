package com.example.casestudy_shoeshop.model;

public class User {
    private int id;
    private String username;
    private String password;
    private int role_id;
    private UserInfo user_info;

    public User() {
    }

    public User(int id, String username, String password, int role_id, UserInfo user_info) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.user_info = user_info;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }
}