package com.mercearia.mercearia.repository;


import com.mercearia.mercearia.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Override
    Optional<Product> findById(String id);

    @Override
    List<Product> findAllById(Iterable<String> ids);

    @Override
    List<Product> findAll();

    List<Product> findByNameContainingIgnoreCase(String name);


    List<Product> findByCategoryIgnoreCase(String category);

    List<Product> findByPrice(Double price);

}

