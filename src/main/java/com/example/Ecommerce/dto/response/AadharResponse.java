package com.example.Ecommerce.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AadharResponse {

    private String aadharNo;
    private CustomerResponse customer;
}
