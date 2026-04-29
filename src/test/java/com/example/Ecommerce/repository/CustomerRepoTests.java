package com.example.Ecommerce.repository;

import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.model.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
//@AutoConfigureTestDatabase
public class CustomerRepoTests {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    public void whenSaveCustomer_thenReturnValidCustomer(){

        Customer customer=Customer.builder()
                .name("test customer")
                .address("test-address")
                .mobNo(9999999999L)
                .email("test@test.com")
                .gender(Gender.MALE)
               .build();

        Customer savedCustomer=customerRepo.save(customer);
        Assertions.assertNotNull(savedCustomer);
        Assertions.assertEquals("test customer",savedCustomer.getName());
    }
}
