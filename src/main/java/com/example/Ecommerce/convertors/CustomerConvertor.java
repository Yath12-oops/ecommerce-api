package com.example.Ecommerce.convertors;

import com.example.Ecommerce.model.Customer;

public class CustomerConvertor {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .name(customerRequest.getName());
                .build();
    }

}
