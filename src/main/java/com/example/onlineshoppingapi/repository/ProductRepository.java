package com.example.onlineshoppingapi.repository;

import com.example.onlineshoppingapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Найти продукты по категории
    List<Product> findByCategory(String category);

    // Найти продукты с ценой меньше или равной
    List<Product> findByPriceLessThanEqual(double maxPrice);

    // Поиск по имени (без учета регистра)
    List<Product> findByNameContainingIgnoreCase(String name);
}