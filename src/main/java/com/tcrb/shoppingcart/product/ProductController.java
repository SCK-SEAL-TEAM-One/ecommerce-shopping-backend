package com.tcrb.shoppingcart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/v1/products")
    public ArrayList<ResponseProduct> getProductList(@RequestParam Integer age_id,@RequestParam Integer gender_id)
    {
        ArrayList<ResponseProduct> responseProductList = new ArrayList<ResponseProduct>();


//        ResponseProduct responseProduct = new ResponseProduct();
//        responseProduct.id = 1;
//        responseProduct.name = "product1";
//        responseProduct.price = 100.00;
//        responseProduct.brand = "Adda";
//        responseProductList.add(responseProduct);

        return responseProductList;
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseProduct getProductDetail(@PathVariable String id)
    {
        ResponseProduct responseProduct = new ResponseProduct();
        Product p = productRepository.findById(Integer.parseInt(id)).get();
        responseProduct.setId(p.getId());
        responseProduct.setName(p.getToyName());
        responseProduct.setGenderId(p.getGender());
        responseProduct.setBrand(p.getBrand());
        responseProduct.setPrice(p.getPrice());
        responseProduct.setAgeId(p.getAgeId());
        responseProduct.setAvailability(p.getAvailability());
        return responseProduct;
    }
}

