package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.OrderRequest;
import com.example.Ecommerce.dto.response.OrderResponse;
import com.example.Ecommerce.exceptions.CustomerNotFoundException;
import com.example.Ecommerce.exceptions.ProductNotFoundException;
import com.example.Ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity placeOrder(@RequestParam("customer-id") int customerId,
                                     @RequestBody List<OrderRequest> orderRequests){

        try{
            String response=orderService.placeOrder(customerId,orderRequests);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        catch (CustomerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (ProductNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity getOrder(@RequestParam("value") int value){

        List<OrderResponse> response=orderService.getOrder(value);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
