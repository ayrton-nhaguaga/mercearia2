package com.ayrton.mercearia.repository;

import com.ayrton.mercearia.model.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

    @Override
    List<Supplier> findAll();

    @Override
    Optional<Supplier> findById(String s);

    @Override
    List<Supplier> findAllById(Iterable<String> strings);

    List<Supplier> findByNameIgnoreCase(String name);

    List<Supplier> findByAddressIgnoreCase(String address);

    List<Supplier> findByTelephoneIgnoreCase(String telephone);

    List<Supplier> findByCategoryIgnoreCase(String category);
}
