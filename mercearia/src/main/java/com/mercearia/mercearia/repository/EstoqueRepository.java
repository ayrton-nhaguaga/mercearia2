package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Estoque;
import com.mercearia.mercearia.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {

    @Override
    List<Estoque> findAll();

    List<Estoque> findByProduto(Produto produto);

    List<Estoque> findByQuantidadeLessThan(int quantidade);

    List<Estoque> findByProduto_PrecoBetween(double min, double max);
}

