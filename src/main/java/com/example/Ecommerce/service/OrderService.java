package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.OrderRequest;
import com.example.Ecommerce.exceptions.CustomerNotFoundException;
import com.example.Ecommerce.exceptions.ProductNotFoundException;
import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.model.OrderEntity;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.repository.CustomerRepo;
import com.example.Ecommerce.repository.OrderRepo;
import com.example.Ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;


    public String placeOrder(int customerId, List<OrderRequest> orderRequests){

        Optional<Customer> customerOptional=customerRepo.findById(customerId);
        if(customerOptional.isEmpty()){
            throw  new CustomerNotFoundException("Invalid customer ID: "+ customerId);
        }
        Customer customer=customerOptional.get();

        List<Product> products=new ArrayList<>();

            int totalValue=0;
        for(OrderRequest orderRequest:orderRequests){
            Optional<Product> productOptional=productRepo.findById(orderRequest.getProductId());
            if(productOptional.isEmpty()){
                throw new ProductNotFoundException("Invalid Product Id "+orderRequest.getProductId());
            }
            Product product=productOptional.get();
            if(product.getQuantity()<orderRequest.getQuantity()){
                throw new ProductNotFoundException("Product out of stock "+orderRequest.getProductId());
            }
            products.add(product);
            totalValue+= product.getPrice()*orderRequest.getQuantity();
        }
        OrderEntity order=new OrderEntity();
        order.setTotalValue(totalValue);
        order.setCustomer(customer);
        order.setProducts(products);

        orderRepo.save(order);

        return "Order placed Successfully";
    }
}
