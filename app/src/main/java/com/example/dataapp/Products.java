package com.example.dataapp;

public class Products {
    private int _id;
    private String product_name;

    public Products() {
    }

    public Products(String product_name) {
        this.product_name = product_name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int get_id() {
        return _id;
    }

    public String getProduct_name() {
        return product_name;
    }
}
