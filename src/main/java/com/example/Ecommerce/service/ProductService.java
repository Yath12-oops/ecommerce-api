package com.example.Ecommerce.service;

import com.example.Ecommerce.convertors.ProductConvertor;
import com.example.Ecommerce.dto.request.ProductRequest;
import com.example.Ecommerce.dto.response.ProductResponse;
import com.example.Ecommerce.exceptions.SellerNotFoundException;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.Seller;
import com.example.Ecommerce.repository.ProductRepo;
import com.example.Ecommerce.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    SellerRepo sellerrepo;

    @Autowired
    ProductRepo productrepo;

    public ProductResponse addProduct(ProductRequest productrequest,int sellerId){

          Optional<Seller> sellerOptional=sellerrepo.findById(sellerId);
          if(sellerOptional.isEmpty()){
            throw new SellerNotFoundException("Invalid seller id:"+sellerId);
          }
          Seller seller=sellerOptional.get();

        Product product= ProductConvertor.productRequestToProduct(productrequest);
        product.setSeller(seller);

        seller.getProducts().add(product);

       Product savedProduct=productrepo.save(product);

        return ProductConvertor.productToProductResponse(savedProduct);
    }
}
