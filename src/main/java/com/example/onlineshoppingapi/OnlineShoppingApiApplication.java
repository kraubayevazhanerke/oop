package com.example.onlineshoppingapi;

import com.example.onlineshoppingapi.entity.Product;
import com.example.onlineshoppingapi.entity.Customer;
import com.example.onlineshoppingapi.repository.ProductRepository;
import com.example.onlineshoppingapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShoppingApiApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            Product p1 = new Product("iPhone 15 Pro", 1299.99, "Electronics", 15);
            Product p2 = new Product("Levi's Jeans", 89.99, "Clothing", 30);
            Product p3 = new Product("Java Programming Book", 49.99, "Books", 25);

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);

            System.out.println("✅ Added 3 sample products to database");
        }

        if (customerRepository.count() == 0) {
            Customer c1 = new Customer("Kraubayeva Zhanerke", "zhanerke@example.com", "87004972409");
            Customer c2 = new Customer("Abai Aisha", "aisha@example.com", "875587980");

            customerRepository.save(c1);
            customerRepository.save(c2);

            System.out.println("✅ Added 2 sample customers to database");
        }
    }
}