package com.mercearia.mercearia.repository;


import com.mercearia.mercearia.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    @Override
    Optional<Produto> findById(String id);

    @Override
    List<Produto> findAllById(Iterable<String> ids);

    @Override
    List<Produto> findAll();

    List<Produto> findByNomeContainingIgnoreCase(String nome);


    List<Produto> findByCategoriaIgnoreCase(String categoria);

    List<Produto> findByPreco(Double preco);

}

