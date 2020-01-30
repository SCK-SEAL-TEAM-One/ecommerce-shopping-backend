package com.tcrb.shoppingcart.product;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    ResponseProduct stubproduct;

    @MockBean
    ProductRepository productRepository;

    @Test
    void getProductListShouldGetAllProducts() {

        List<Product> stubProductList = new ArrayList<>();
        Product product = new Product();
        product.setId(1);
        product.setToyName("Balance Training Bicycle");
        product.setPrice(123.12);
        product.setAvailability(10);

        Product product2 = new Product();
        product2.setId(2);
        product2.setToyName("43 Piece dinner Set");
        product2.setPrice(123.12);
        product2.setAvailability(10);

        stubProductList.add(product);
        stubProductList.add(product2);

        given(productRepository.findAll())
                .willReturn(stubProductList);

        ResponseProduct[] result
                = restTemplate.getForObject("/api/v1/products", ResponseProduct[].class);

        assertEquals(2,result.length);
        assertEquals("Balance Training Bicycle",result[0].getName());
        assertTrue(result[0].isAvailability());
        assertEquals("43 Piece dinner Set",result[1].getName());
        assertTrue(result[1].isAvailability());
    }

    @Test
    void getProductByDetail() {
        stubproduct.setId(1);
        stubproduct.setName("Balance Trainning Bicycle");

        ResponseProduct result
                = restTemplate.getForObject("/api/v1/products/1", ResponseProduct.class);
        assertEquals(1,result.getId());
        assertEquals("Balance Trainning Bicycle",result.getName());
    }


}