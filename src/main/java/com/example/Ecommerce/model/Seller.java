package com.example.Ecommerce.model;

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
public class Seller {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int sellerId;


    private String name;
    private long mobNo;
    private String address;

    @Column(unique = true)
    private String email;

    private String gstNo;

    @OneToMany(mappedBy = "seller")
   private List<Product> products=new ArrayList<>();
}
