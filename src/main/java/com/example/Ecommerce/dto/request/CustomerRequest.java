package com.example.Ecommerce.dto.request;

import com.example.Ecommerce.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String name;
    private String address;
    private long mobile;
    private String email;
    private Gender gender;

}
