package com.example.casestudy_shoeshop.model;

import java.sql.Date;
import java.time.LocalDate;

public class UserInfo {
    private  int user_id;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    private String address;

    public UserInfo() {
    }

    public UserInfo(int user_id, String name, Date dob, String email, String phone, String address) {
        this.user_id = user_id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public UserInfo(String name, Date dob, String email, String phone, String address) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
