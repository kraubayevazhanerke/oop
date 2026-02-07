package com.example.onlineshoppingapi.controller;  // ← ЭТО ВАЖНО!

import com.example.onlineshoppingapi.entity.Product;  // ← импорт из entity
import com.example.onlineshoppingapi.repository.ProductRepository;  // ← импорт из repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // 1. ПОЛУЧИТЬ ВСЕ ПРОДУКТЫ
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. ПОЛУЧИТЬ ПРОДУКТ ПО ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. СОЗДАТЬ НОВЫЙ ПРОДУКТ
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 4. ОБНОВИТЬ ПРОДУКТ
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Product product = productRepository.findById(id).get();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        product.setStockQuantity(productDetails.getStockQuantity());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // 5. УДАЛИТЬ ПРОДУКТ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 6. ПОИСК ПО ИМЕНИ
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    // 7. ФИЛЬТР ПО КАТЕГОРИИ
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }

    // 8. ФИЛЬТР ПО ЦЕНЕ
    @GetMapping("/filter/price")
    public List<Product> filterByPrice(@RequestParam double maxPrice) {
        return productRepository.findByPriceLessThanEqual(maxPrice);
    }
}