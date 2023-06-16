package com.example.casestudy_shoeshop.dto;

import com.example.casestudy_shoeshop.model.enums.EPrice;

import java.util.List;

public class Pageable {

    private String search;
    private int page;
    private int totalItems;
    private int totalPage;
    private String nameField;
    private String sortBy;

    private String priceString;

    private List<EPrice> prices;


    public Pageable(String search, int page, int totalItems, int totalPage) {
        this.search = search;
        this.page = page;
        this.totalItems = totalItems;
        this.totalPage = totalPage;
    }

    public Pageable(String search, int page, int totalItems, String nameField, String sortBy) {
        this.search = search;
        this.page = page;
        this.totalItems = totalItems;
        this.nameField = nameField;
        this.sortBy = sortBy;
    }

    public Pageable(String search, String priceString) {
        this.search = search;
        this.priceString = priceString;
    }

    public Pageable(String s) {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public List<EPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<EPrice> prices) {
        this.prices = prices;
    }
}
