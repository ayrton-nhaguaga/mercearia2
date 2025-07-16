package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Stock;
import com.mercearia.mercearia.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

    @Override
    List<Stock> findAll();

    List<Stock> findByProductName(String name);

    List<Stock> findByQuantityLessThan(int quantity);

    List<Stock> findByProductPriceBetween(double min, double max);
}

