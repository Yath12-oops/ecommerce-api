package com.example.Ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping
    public String homepage(){
        return "HOME PAGE";
    }

    @GetMapping("/student")
    public String studentPage(){
        return "STUDENT PAGE";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "ADMIN PAGE";
    }

}
