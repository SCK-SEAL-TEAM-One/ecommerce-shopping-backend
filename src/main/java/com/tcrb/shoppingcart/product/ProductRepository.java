package com.tcrb.shoppingcart.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByAgeIdAndGenderId(int ageId, String genderId);
}
