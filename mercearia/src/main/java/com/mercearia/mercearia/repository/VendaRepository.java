package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VendaRepository extends MongoRepository<Venda, String> {

    @Override
    Optional<Venda> findById(String id);

    @Override
    List<Venda> findAll();

    @Override
    List<Venda> findAllById(Iterable<String> ids);

    List<Venda> findByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Venda> findByData(LocalDateTime data);

    List<Venda> findByProdutoNome(@Param("produtoNome") String produtoNome);

    List<Venda> findByItemVendido(String itemVendido);

    List<Venda> findByQuantidade(int quantidade);

    List<Venda> findByFuncionario(String funcionario);
}
