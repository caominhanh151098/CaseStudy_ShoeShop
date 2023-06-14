package com.example.casestudy_shoeshop.model;

import java.sql.Date;

public class UserInfo {
    private  int user_id;
    private String name;
    private Date dob;
    private String email;
    private String phone;

    public UserInfo() {
    }



    public UserInfo(int user_id, String name, Date dob, String email, String phone) {
        this.user_id = user_id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    public UserInfo(int id, String username, String password, int roleId) {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
