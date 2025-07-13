package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {

    @Override
    Optional<Venda> findById(String id);

    @Override
    List<Venda> findAll();

    @Override
    List<Venda> findAllById(Iterable<String> ids);

    List<Venda> findByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<Venda> findByDataVenda(LocalDateTime data);


    List<Venda> findByItemVendidoIgnoreCase(String itemVendido);

    List<Venda> findByQuantidadeVendida(int quantidadeVendida);

    List<Venda> findByFuncionarioIgnoreCase(String funcionario);
}
