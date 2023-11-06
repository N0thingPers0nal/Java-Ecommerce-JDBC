package com.java_ecommerce_jdbc.models;

import com.java_ecommerce_jdbc.utils.AppException;

public class Product {
    private int id;
    private String title;
    private String desc;
    private double price;
    private int categoryId;
    public Product(){}

    public Product(int id, String title, String desc, double price, int stocks, int categoryId) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws AppException {
        if (price <= 0) {
            throw new AppException("Price cannot be negative");
        }
        this.price = price;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


}
