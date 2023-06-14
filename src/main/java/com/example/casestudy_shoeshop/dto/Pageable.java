package com.example.casestudy_shoeshop.dto;

public class Pageable {

    private String search;

    public Pageable(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
