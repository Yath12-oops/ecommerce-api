package com.example.Ecommerce.model;

import com.example.Ecommerce.model.enums.ProductCategory;
import com.jayway.jsonpath.internal.function.numeric.Min;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private  String name;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    private int price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToMany(mappedBy = "products")
    List<OrderEntity> orders=new ArrayList<>();
}
