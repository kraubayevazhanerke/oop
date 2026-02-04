package com.example.onlineshoppingapi.repository;

import com.example.onlineshoppingapi.entity.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/online_shop_db";
    private static final String USER = "java_user";
    private static final String PASSWORD = "java123";

    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                if ("Electronics".equals(category)) {
                    list.add(new Electronics(name, price, rs.getInt("warranty_months")));
                } else {
                    list.add(new Clothing(name, price, rs.getString("size")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}