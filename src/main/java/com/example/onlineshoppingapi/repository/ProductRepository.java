package com.example.onlineshoppingapi.repository;

import com.example.onlineshoppingapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByPriceLessThanEqual(Double maxPrice);
    List<Product> findByNameContainingIgnoreCase(String name);
}