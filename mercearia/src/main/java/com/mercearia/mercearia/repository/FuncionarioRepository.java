package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.FuncionarioDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<FuncionarioDTO, String> {

    @Override
    List<FuncionarioDTO> findAllById(Iterable<String> strings);

    @Override
    List<FuncionarioDTO> findAll(Sort sort);

    List<FuncionarioDTO> findByNomeIgnoreCase(String nome);

    List<FuncionarioDTO> findByEmailIgnoreCase(String email);

    void deleteByNomeIgnoreCase(String nome);
}
