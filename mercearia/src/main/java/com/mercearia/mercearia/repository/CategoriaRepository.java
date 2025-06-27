package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {

    List<Categoria> findByCategoria(String categoria);

    @Override
    List<Categoria> findAll();

    void deleteByCategoria(String categoria);
}

