package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.CategoriaDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends MongoRepository <CategoriaDTO, String>{
    @Override
    List<CategoriaDTO> findAll();

    List<CategoriaDTO> findCategoriaById(String id);

    List<CategoriaDTO> findByCategoriaIgnoreCase(String categoria);

    void deleteByCategoriaIgnoreCase(String categoria);
}
