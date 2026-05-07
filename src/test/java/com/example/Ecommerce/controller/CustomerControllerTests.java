package com.example.Ecommerce.controller;

import com.example.Ecommerce.dto.request.CustomerRequest;
import com.example.Ecommerce.dto.response.CustomerResponse;
import com.example.Ecommerce.model.enums.Gender;
import com.example.Ecommerce.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void whenAddCustomer_thenReturnValidResponse() throws Exception {

        CustomerRequest request = CustomerRequest.builder()
                .name("Test Customer")
                .address("test address")
                .mobile(9999999999L)
                .email("test@test.com")
                .gender(Gender.FEMALE)
                .build();

        CustomerResponse response = CustomerResponse.builder()
                .name("Test Customer")
                .email("test@test.com")
                .build();

        Mockito.when(customerService.addCustomer(any(CustomerRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value(response.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email")
                .value(response.getEmail()));
    }
}
