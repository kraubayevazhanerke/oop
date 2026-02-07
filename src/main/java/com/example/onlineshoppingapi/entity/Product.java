package com.example.onlineshoppingapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    private String category;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    // Пустой конструктор (обязательно для JPA)
    public Product() {}

    // Конструктор с параметрами
    public Product(String name, double price, String category, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    // Геттеры
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Сеттеры
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // toString для отладки
    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s', price=%.2f, category='%s', stock=%d]",
                id, name, price, category, stockQuantity);
    }
}