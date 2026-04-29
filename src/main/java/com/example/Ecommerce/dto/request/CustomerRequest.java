package com.example.Ecommerce.dto.request;

import com.example.Ecommerce.model.enums.Gender;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    private String name;
    private String address;
    private long mobile;
    private String email;
    private Gender gender;

}
