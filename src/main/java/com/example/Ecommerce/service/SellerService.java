package com.example.Ecommerce.service;


import com.example.Ecommerce.convertors.SellerConvertor;
import com.example.Ecommerce.dto.request.SellerRequest;
import com.example.Ecommerce.dto.response.SellerResponse;
import com.example.Ecommerce.model.Seller;
import com.example.Ecommerce.repository.SellerRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    SellerRepo sellerRepo;

    public SellerResponse addSeller(SellerRequest sellerrequest) {
        Seller seller=SellerConvertor.sellerRequestToSeller(sellerrequest);
        Seller savedSeller=sellerRepo.save(seller);
        return SellerConvertor.sellerToSellerResponse(savedSeller);
    }
    public Seller getSellerById(int id){
        Optional<Seller> sellerOptional=sellerRepo.findById(id);
        if(sellerOptional.isEmpty()){
            throw new RuntimeException("Invalid Seller");
        }
        return sellerOptional.get();
    }

    public Seller updateSellerById(int id,long mobNo){

        Optional<Seller> sellerOptional=sellerRepo.findById(id);

        if(sellerOptional.isEmpty()){
            throw new RuntimeException(" Seller Not Found");
        }
        Seller seller=sellerOptional.get();
        seller.setMobNo(mobNo);

        return sellerRepo.save(seller);
    }

    public String deleteSellerById(int id){
    Optional<Seller> optionalSeller=sellerRepo.findById(id);

    if(optionalSeller.isEmpty()){
        throw new RuntimeException("Seller not found");
    }
    Seller seller=optionalSeller.get();
        sellerRepo.delete(seller);
        return "DELETE SUCCESFULLY";
    }
}
