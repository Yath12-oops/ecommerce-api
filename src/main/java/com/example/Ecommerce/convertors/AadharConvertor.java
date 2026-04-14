package com.example.Ecommerce.convertors;

import com.example.Ecommerce.dto.response.AadharResponse;
import com.example.Ecommerce.model.Aadhar;

public class AadharConvertor {

    public static AadharResponse aadharToaadharResponse(Aadhar aadhar){
        return AadharResponse.builder()
                .aadharNo(aadhar.getAadharNo())
                .customer(CustomerConvertor.customerToCustomerResponse(aadhar.getCustomer()))
                 .build();
    }
}
