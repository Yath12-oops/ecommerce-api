package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aadharId;

    @Column(unique = true)
    private String aadharNo;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
