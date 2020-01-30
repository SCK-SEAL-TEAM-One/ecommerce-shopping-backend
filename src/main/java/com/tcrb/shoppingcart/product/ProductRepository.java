package com.tcrb.shoppingcart.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findByAgeAndGender(int ageId, String genderId);
}
