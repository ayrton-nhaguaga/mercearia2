package com.mercearia.mercearia.repository;

import com.mercearia.mercearia.dto.FornecedorDTO;
import com.mercearia.mercearia.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {

    @Override
    List<Fornecedor> findAll();

    @Override
    Optional<Fornecedor> findById(String s);

    @Override
    List<Fornecedor> findAllById(Iterable<String> strings);

    List<Fornecedor> findByNomeIgnoreCase(String nome);

    List<Fornecedor> findByEnderecoIgnoreCase(String endereco);

    List<Fornecedor> findByTelefone(String telefone);

    void deleteByNome(String nome);
}
