package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.dto.ProdutoDTO;
import com.mercearia.mercearia.model.Estoque;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {
    @Override
    List<Estoque> findAll();

    List<Estoque> procurarEstoquePeloProduto(ProdutoDTO produto);

    List<Estoque> procurarEstoqueQuantidadeMenor(int quantidade);

    List<Estoque> findByPriceBetween(double min, double max);
}
