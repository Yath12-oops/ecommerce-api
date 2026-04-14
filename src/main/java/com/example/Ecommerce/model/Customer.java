package com.example.Ecommerce.model;

import com.example.Ecommerce.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

//    @Column(name="full_name")
    private String name;

    private String address;

    @Column(nullable = false)
    private long mobNo;

    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    private Date createdAt; // when the account was created

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Aadhar aadhar;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders = new ArrayList<>();
}
