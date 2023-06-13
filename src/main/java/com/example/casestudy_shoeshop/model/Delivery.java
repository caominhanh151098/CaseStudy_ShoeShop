package com.example.casestudy_shoeshop.model;

public class Delivery {
    private int id;
    private String delivery_place;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private static int currentID;

    public Delivery() {
    }

    public Delivery(int id, String delivery_place, String customer_name, String customer_email, String customer_phone) {
        this.id = id;
        this.delivery_place = delivery_place;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
    }

    public Delivery(String delivery_place, String customer_name, String customer_email, String customer_phone) {
        this.delivery_place = delivery_place;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDelivery_place() {
        return delivery_place;
    }

    public void setDelivery_place(String delivery_place) {
        this.delivery_place = delivery_place;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }
}
