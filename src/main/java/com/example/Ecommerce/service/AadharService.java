package com.example.Ecommerce.service;

import com.example.Ecommerce.convertors.AadharConvertor;
import com.example.Ecommerce.dto.response.AadharResponse;
import com.example.Ecommerce.exceptions.CustomerNotFoundException;
import com.example.Ecommerce.model.Aadhar;
import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.repository.AadharRepo;
import com.example.Ecommerce.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AadharService {

        @Autowired
    CustomerRepo customerRepo;

        @Autowired
        AadharRepo aadharRepo;

    public AadharResponse addAadhar(String aadharNo,int customerId){

        Optional<Customer> customerOptional=customerRepo.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer Id"+customerId);
        }
        Customer customer=customerOptional.get();

        Aadhar aadhar=Aadhar.builder().aadharNo(aadharNo).customer(customer).build();

        Aadhar savedAadhar=aadharRepo.save(aadhar);

        return AadharConvertor.aadharToaadharResponse(savedAadhar);
    }
}
