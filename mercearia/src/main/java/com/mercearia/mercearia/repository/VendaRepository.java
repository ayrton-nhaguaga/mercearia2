package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VendaRepository extends MongoRepository<Venda, String> {
    @Override
    Optional<Venda> findById(String id);

    @Override
    List<Venda> findAll();

    List<Venda> findByItemVendido(String itemVendido);

    List<Venda> findByQuantidade(String quantidade);

    List<Venda> findByFuncionario(String funcionario);

    List<Venda> findByData(LocalDateTime data);
}
