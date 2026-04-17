package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
}
