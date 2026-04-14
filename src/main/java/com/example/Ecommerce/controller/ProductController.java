package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.ProductRequest;
import com.example.Ecommerce.dto.response.ProductResponse;
import com.example.Ecommerce.exceptions.SellerNotFoundException;
import com.example.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")

public class ProductController {

    @Autowired
    ProductService productservice;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductRequest productrequest,
                                     @RequestParam("seller-id") int sellerId){
        try {
            ProductResponse response = productservice.addProduct(productrequest, sellerId);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
