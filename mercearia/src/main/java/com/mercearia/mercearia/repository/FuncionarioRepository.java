package com.mercearia.mercearia.repository;
import com.mercearia.mercearia.dto.FornecedorDTO;
import com.mercearia.mercearia.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{
    @Override
    Optional<Funcionario> findById(String id);

    @Override
    List<Funcionario> findAll();

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    List<Funcionario> findByTelefone(String telefone);

    List<Funcionario> findByEmail(String email);

    List<Funcionario> findByEndereco(String endereco);

    void deleteByNome(String nome);
}
