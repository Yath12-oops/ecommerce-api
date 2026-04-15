package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    CustomerRepo customerRepo;

//    public void placeOrder(int customerId, List<Integer> productIds){
//
//        Optional<Customer> customerOptional=CustomerRepo.
//    }
}
