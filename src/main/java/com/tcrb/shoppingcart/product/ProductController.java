package com.tcrb.shoppingcart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/v1/products")
    public List<ResponseProduct> getProductList(
            @RequestParam(name="age_id") int ageId,
            @RequestParam(name="gender_id") String genderId)
    {
        List<ResponseProduct> responseProductList = new ArrayList<>();
        List<Product> productList = (List<Product>) productRepository.findByAgeIdAndGenderId(ageId,genderId);
        for (Product product : productList) {
            ResponseProduct responseProduct = new ResponseProduct();
            responseProduct.setId(product.getId());
            responseProduct.setName(product.getToyName());
            responseProduct.setGenderId(product.getGender());
            responseProduct.setAgeId(product.getAgeId());
            responseProduct.setPrice(product.getPrice());
            responseProduct.setAvailability(product.isProductIsAvailable());
            responseProductList.add(responseProduct);
        }

        return responseProductList;
    }

    @GetMapping("/api/v1/products/{id}")
    public ResponseProduct getProductDetail(@PathVariable String id)
    {
        ResponseProduct responseProduct = new ResponseProduct();
        responseProduct.setId(1);
        responseProduct.setName("Balance Trainning Bicycle");
//        ResponseProduct responseProduct = new ResponseProduct();
//        responseProduct.id = 1;
//        responseProduct.name = "product1";
//        responseProduct.price = 100.00;
//        responseProduct.brand = "Adda";
//        responseProductList.add(responseProduct);

        return responseProduct;
    }
}

