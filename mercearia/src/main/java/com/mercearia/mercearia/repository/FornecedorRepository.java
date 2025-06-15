package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.FornecedorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends MongoRepository<FornecedorDTO, String> {

    @Override
    List<FornecedorDTO> findAll();

    @Override
    List<FornecedorDTO> findAllById(Iterable<String> strings);

    List<FornecedorDTO> findByNomeIgnoreCase(String nome);

    List<FornecedorDTO> findByEnderecoIgnoreCase(String endereco);

    List<FornecedorDTO> findByTelefone(String telefone);

    void deleteByNomeIgnoreCase(String nome);
}
