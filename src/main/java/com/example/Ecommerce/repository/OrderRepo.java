package com.example.Ecommerce.repository;

import com.example.Ecommerce.dto.response.OrderResponse;
import com.example.Ecommerce.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<OrderEntity,Integer> {
    List<OrderEntity> findBytotalValueGreaterThan(int value);
}
