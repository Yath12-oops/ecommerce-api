package com.example.Ecommerce.convertors;

import com.example.Ecommerce.dto.request.SellerRequest;
import com.example.Ecommerce.dto.response.SellerResponse;
import com.example.Ecommerce.model.Seller;

public class SellerConvertor {

    public static Seller sellerRequestToSeller(SellerRequest sellerrequest){
        return Seller.builder()
                .name(sellerrequest.getName())
                .mobNo(sellerrequest.getMobNo())
                .address(sellerrequest.getAddress())
                .email(sellerrequest.getEmail())
                .gstNo(sellerrequest.getGstNo())
                .build();

    }
    public static SellerResponse sellerToSellerResponse(Seller seller){
        return SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();

    }
}
