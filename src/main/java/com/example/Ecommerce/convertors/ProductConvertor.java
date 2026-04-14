package com.example.Ecommerce.convertors;

import com.example.Ecommerce.dto.request.ProductRequest;
import com.example.Ecommerce.dto.response.ProductResponse;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.repository.ProductRepo;


public class ProductConvertor {

    public static Product productRequestToProduct(ProductRequest productrequest){

        return Product.builder()
                .name(productrequest.getName())
                .productCategory(productrequest.getProductCategory())
                .price(productrequest.getPrice())
                .quantity(productrequest.getQuantity())
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
