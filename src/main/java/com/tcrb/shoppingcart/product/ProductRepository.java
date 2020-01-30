package com.tcrb.shoppingcart.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByAgeIdAndGenderId(int ageId, String genderId);
}
