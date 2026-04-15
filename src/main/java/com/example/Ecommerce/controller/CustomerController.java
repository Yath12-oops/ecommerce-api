package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.CustomerRequest;
import com.example.Ecommerce.dto.response.CustomerResponse;
import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest){
    CustomerResponse response=customerService.addCustomer((customerRequest));
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getCustomer(@RequestParam("id") int id){
        Customer c=customerService.getCustomer(id);
        return new ResponseEntity(c,HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getAllCustomersByName(@PathVariable("name") String name){
       List<Customer> response=customerService.getAllCustomersByName(name);
       return new ResponseEntity(response,HttpStatus.OK);
    }
}
