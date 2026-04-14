package com.example.Ecommerce.dto.request;


import com.example.Ecommerce.model.enums.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


    private String name;
    private ProductCategory productCategory;
    private int price;
    private int quantity;

    //seller -request param
}
