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
    void getProductListByGenderIdFAndAgeId2ShouldProducts() {
        int ageId = 2;
        String genderId = "F";

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

        given(productRepository.findByAgeIdAndGenderId(ageId,genderId))
                .willReturn(stubProductList);

        ResponseProduct[] result
                = restTemplate.getForObject("/api/v1/products?age_id=2&gender_id=F", ResponseProduct[].class);

        assertEquals(2,result.length);
        assertEquals("Balance Training Bicycle",result[0].getName());
        assertEquals(result[0].getAvailability(),product.getAvailability());
        assertEquals("43 Piece dinner Set",result[1].getName());
        assertEquals(result[1].getAvailability(),product.getAvailability());
    }

    @Test
    void getProductByDetail() {


        Product stubProduct = new Product();

        stubProduct.setId(30);
        stubProduct.setToyName("Fisher-Price stroller");
        stubProduct.setGender("F");
        stubProduct.setAgeId(2);
        stubProduct.setPrice(25.99);
        stubProduct.setAvailability(10);
        stubProduct.setBrand("CoolKidz");


        given(productRepository.findById(30)).willReturn(Optional.of(stubProduct));
        ResponseProduct result
                = restTemplate.getForObject("/api/v1/products/30", ResponseProduct.class);

        assertEquals(stubProduct.getId(),result.getId());
        assertEquals(stubProduct.getToyName(),result.getName());
        assertEquals(stubProduct.getGender(),result.getGenderId());
        assertEquals(stubProduct.getAgeId(),result.getAgeId());
        assertEquals(stubProduct.getPrice(),result.getPrice());
        assertEquals(stubProduct.getAvailability(),result.getAvailability());
        assertEquals(stubProduct.getBrand(),result.getBrand());




    }


}