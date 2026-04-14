package com.example.Ecommerce.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private String name;
    private String email;
    private Date ccreatedAt;
}
