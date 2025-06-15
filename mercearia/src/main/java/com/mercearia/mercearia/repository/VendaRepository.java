package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.VendaDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends MongoRepository <VendaDTO, String> {
    @Override
    List<VendaDTO> findAll();

    @Override
    List<VendaDTO> findAllById(Iterable<String> strings);

    List<VendaDTO> findByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim);

    List<VendaDTO> findByData(LocalDateTime data);

    List<VendaDTO> findByProdutoNome(@Param("ProdutoNome") String produtoNome);
}
