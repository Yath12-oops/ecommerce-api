package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.response.AadharResponse;
import com.example.Ecommerce.exceptions.CustomerNotFoundException;
import com.example.Ecommerce.model.Aadhar;
import com.example.Ecommerce.service.AadharService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/aadhar")
public class AadharController {
    @Autowired
    AadharService aadharService;

    @PostMapping
    public ResponseEntity addAadhar(@RequestParam("aadhar-no") String aadharNo,
                                    @RequestParam("customer-id") int customerId){
        try {
            AadharResponse aadharResponse = aadharService.addAadhar(aadharNo, customerId);
            return new ResponseEntity(aadharResponse, HttpStatus.CREATED);
        }catch(CustomerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
