package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.dto.ProdutoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends MongoRepository<EstoqueDTO, String> {
    @Override
    List<EstoqueDTO> findAll();

    List<EstoqueDTO> findByProduto(ProdutoDTO produto);

    List<EstoqueDTO> findByNomeIgnoreCase(String nome);

    List<EstoqueDTO> findByQuantidadeMenor(int quantidade);

    void deleteByNomeIgnoreCase(String nome);
}
