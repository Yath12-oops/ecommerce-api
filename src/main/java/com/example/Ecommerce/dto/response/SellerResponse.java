package com.example.Ecommerce.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerResponse {
    private String name;
    private String email;
}
