package com.example.Ecommerce.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequest {

    private String name;
    private long mobNo;
    private String address;
    private String email;
    private String gstNo;
}
