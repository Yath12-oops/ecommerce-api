package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
