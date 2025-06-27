package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends MongoRepository<Produto, String> {

    @Override
    Optional<Produto> findById(String id);

    @Override
    List<Produto> findAllById(Iterable<String> ids);

    @Override
    List<Produto> findAll();

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByNomeIgnoreCase(String nome);

    List<Produto> findByCategoria(String categoria);

    List<Produto> findByCategoriaIgnoreCase(String categoria);

    List<Produto> findByPreco(Double preco);

    void deleteByNome(String nome);
}

