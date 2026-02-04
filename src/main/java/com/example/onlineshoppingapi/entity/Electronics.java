package com.example.onlineshoppingapi.entity;

public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics() {}
    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String getCategory() { return "Electronics"; }
    public int getWarrantyMonths() { return warrantyMonths; }
}