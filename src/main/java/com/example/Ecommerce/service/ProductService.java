package com.example.Ecommerce.service;

import com.example.Ecommerce.convertors.ProductConvertor;
import com.example.Ecommerce.dto.request.ProductRequest;
import com.example.Ecommerce.dto.response.ProductResponse;
import com.example.Ecommerce.exceptions.ProductNotFoundException;
import com.example.Ecommerce.exceptions.SellerNotFoundException;
import com.example.Ecommerce.model.Product;
import com.example.Ecommerce.model.Seller;
import com.example.Ecommerce.model.enums.ProductCategory;
import com.example.Ecommerce.repository.ProductRepo;
import com.example.Ecommerce.repository.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<ProductResponse> getProductOfACategory(ProductCategory productCategory){
        List<Product> products=productrepo.findByProductCategory(productCategory);
        if(products.isEmpty()){
            throw new ProductNotFoundException("Invalid Product Category");
        }
        List<ProductResponse> productResponses=new ArrayList<>();
        for(Product p:products){
            productResponses.add(ProductConvertor.productToProductResponse(p));
        }
        return productResponses;
    }

    public List<ProductResponse> getProductInRange(int min,int max){

        List<Product> products=productrepo.findByPriceBetween(min,max);

        if(products.isEmpty()){
            throw new ProductNotFoundException("No valid product");
        }
        List<ProductResponse> responses=new ArrayList<>();

        for(Product p:products){
            responses.add(ProductConvertor.productToProductResponse(p));
        }
        return responses;
    }

    public List<ProductResponse> getOutOfStockProducts(){

        List<Product> products=productrepo.findByQuantity(0);
        if(products.isEmpty()){
            throw new ProductNotFoundException("No product is out of stock");
        }

        List<ProductResponse> responses=new ArrayList<>();
        for(Product p:products){
            responses.add(ProductConvertor.productToProductResponse(p));
        }

        return responses;
    }

    public List<ProductResponse> getInStockProducts(){

        List<Product> products=productrepo.findByQuantityGreaterThan(0);
        if(products.isEmpty()){
            throw new ProductNotFoundException("No product is in stock");
        }

        List<ProductResponse> responses=new ArrayList<>();
        for(Product p:products){
            responses.add(ProductConvertor.productToProductResponse(p));
        }

        return responses;
    }
}
