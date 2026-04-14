package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.SellerRequest;
import com.example.Ecommerce.dto.response.SellerResponse;
import com.example.Ecommerce.model.Seller;
import com.example.Ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerrequest){
        SellerResponse response=sellerService.addSeller(sellerrequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getSellerById(@PathVariable("id") int id){
        Seller response=sellerService.getSellerById(id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateSellerById(@PathVariable("id") int id,
                                           @RequestParam("mobNo") long mobNo){
        Seller response=sellerService.updateSellerById(id,mobNo);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteSellerById(@PathVariable("id") int id){
        String response=sellerService.deleteSellerById(id);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
