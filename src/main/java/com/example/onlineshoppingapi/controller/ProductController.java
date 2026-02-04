package com.example.onlineshoppingapi.controller;

import com.example.onlineshoppingapi.entity.Product;
import com.example.onlineshoppingapi.repository.DatabaseManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return DatabaseManager.getAllProducts();
    }

    @GetMapping("/products/search")
    public Product search(@RequestParam String name) {
        return DatabaseManager.getAllProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}
