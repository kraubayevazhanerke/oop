package com.example.onlineshoppingapi.entity;

public class Clothing extends Product {
    private String size;

    public Clothing() {}
    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    @Override
    public String getCategory() { return "Clothes"; }
    public String getSize() { return size; }
}