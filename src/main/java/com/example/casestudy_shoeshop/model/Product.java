package com.example.casestudy_shoeshop.model;

public class Product {
     private int id;
     private String product_name;
     private double price;
     private String description;
     private String image;
     private Category category;

    public Product() {
    }

    public Product(String product_name, double price, String description, String image, Category category) {
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public Product(int id, String product_name, double price, String description, String image, Category category) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }
    public String displayProductName() {
        if (product_name.length() > 20) {
            return product_name.substring(0, 20) + "...";
        }
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
