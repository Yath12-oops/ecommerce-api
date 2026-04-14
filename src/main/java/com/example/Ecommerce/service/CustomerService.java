package com.example.Ecommerce.service;

import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.List;
@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    public String addCustomer(Customer customer){
        customerRepo.save(customer);
        return "Customer added succesfully";
    }

    public Customer getCustomer(int id) {
       Optional<Customer> customerOptional=customerRepo.findById(id);
       if(customerOptional.isEmpty()){
           throw new RuntimeException("Invalid customer id");
       }
       return customerOptional.get();
    }

    public List<Customer> getAllCustomersByName(String name){
      return customerRepo.findByName(name);
    }
}
