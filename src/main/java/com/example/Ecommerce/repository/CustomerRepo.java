package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findByName(String name);
}
