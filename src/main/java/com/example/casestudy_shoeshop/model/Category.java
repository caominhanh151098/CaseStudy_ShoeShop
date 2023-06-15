package com.example.casestudy_shoeshop.model;

public class Category {
    private int id;
    private String categoryName;
    private String img;

    public Category(String categoryName, String img) {
        this.categoryName = categoryName;
        this.img = img;
    }

    public Category(int id, String categoryName, String img) {
        this.id = id;
        this.categoryName = categoryName;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
