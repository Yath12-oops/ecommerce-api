package com.example.Ecommerce.service;

import com.example.Ecommerce.dto.request.CustomerRequest;
import com.example.Ecommerce.dto.response.CustomerResponse;
import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.model.enums.Gender;
import com.example.Ecommerce.repository.CustomerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @Mock
    CustomerRepo customerRepo;

    @InjectMocks
    CustomerService customerService;

    @Test
    public void whenSaveCustomer_thenReturnValidCustomer(){
        CustomerRequest customerRequest= CustomerRequest.builder()
                .name("Test Customer")
                .address("test address")
                .mobile(9999999999L)
                .email("test@test.com")
                .gender(Gender.FEMALE)
                .build();

        Customer dummyCustomer=Customer.builder()
                .customerId(1)
                .name("Test Customer")
                .address("test address")
                .mobNo(9999999999L)
                .email("test@test.com")
                .gender(Gender.FEMALE)
                .createdAt(new Date())
                .build();

        Mockito.when(customerRepo.save(any(Customer.class))).thenReturn(dummyCustomer);
        CustomerResponse response=customerService.addCustomer(customerRequest);
        Assertions.assertEquals("Test Customer",response.getName());
        Assertions.assertNotNull(response.getCreatedAt());
        Assertions.assertEquals("test@test.com",response.getEmail());
    }
}
