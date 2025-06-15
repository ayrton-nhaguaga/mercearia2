package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.ProdutoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository  extends MongoRepository<ProdutoDTO, String> {
    @Override
    List<ProdutoDTO> findAll();

    List<ProdutoDTO> findByNomeIgnoreCase(String nome);

    List<ProdutoDTO> findByCategoriaIgnoreCase(String categoria);
}
