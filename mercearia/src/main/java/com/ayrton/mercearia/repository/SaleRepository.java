package com.ayrton.mercearia.repository;

import com.ayrton.mercearia.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends MongoRepository<Sale, String> {

    @Override
    Optional<Sale> findById(String id);

    @Override
    List<Sale> findAll();

    @Override
    List<Sale> findAllById(Iterable<String> ids);

    List<Sale> findBySaleDateBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Sale> findBySaleDate(LocalDateTime data);


    List<Sale> findByItemSoldNameIgnoreCase(String name);

    List<Sale> findByQuantitySold(int quantitySold);

    List<Sale> findBySupplierNameIgnoreCase(String name);
}
