package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.enums.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findByProductCategory(ProductCategory productCategory);
    List<Product> findByPriceBetween(int min,int max);
}
