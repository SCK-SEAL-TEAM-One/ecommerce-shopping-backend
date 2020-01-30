package com.tcrb.shoppingcart.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ResponseProduct stubproduct;

    @Autowired
    ProductRepository productRepository;

    @Test
    void getProductList() {
        ResponseProduct result
                = restTemplate.getForObject("/api/v1/products", ResponseProduct.class);

        assertEquals(0,result.getId());
    }

    //@Test
    void getProductByDetail() {
//        stubproduct.setId(1);
//        stubproduct.setName("Balance Trainning Bicycle");
//
//        ResponseProduct result
//                = restTemplate.getForObject("/api/v1/products/1", ResponseProduct.class);
//        assertEquals(1,result.getId());
//        assertEquals("Balance Trainning Bicycle",result.getName());
        Product product = new Product();
        product.setId(30);
        productRepository.save(product);

        Product px = productRepository.findById(30).get();
        ResponseProduct expectResult = new ResponseProduct();
        expectResult.setId(30);
        expectResult.setName("Fisher-Price stroller");
        expectResult.setGenderId("F");
        expectResult.setAgeId(2);
        expectResult.setPrice(25.99);
        expectResult.setAvailability(10);
        expectResult.setBrand("CoolKidz");
        expectResult.setImageName(null);

        ResponseProduct result
                = restTemplate.getForObject("/api/v1/products/30", ResponseProduct.class);

        assertEquals(px.getId(),result.getId());
    }


}