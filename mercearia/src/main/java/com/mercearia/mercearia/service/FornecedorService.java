package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.FornecedorDTO;
import com.mercearia.mercearia.model.Fornecedor;
import com.mercearia.mercearia.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor createFornecedor(FornecedorDTO dto){
        Fornecedor service = new Fornecedor();
        service.setNome(dto.getNome());
        service.setCategoria(dto.getCategoria());
        service.setEndereco(dto.getEndereco());
        service.setTelefone(dto.getTelefone());
        return repository.save(service);
    }

    public List<Fornecedor> getAllFornecedores(){
        return repository.findAll();
    }

    public List<Fornecedor> getByNomeIgnoreCase(String nome){
        return repository.findByNomeIgnoreCase(nome);
    }

    public List<Fornecedor> getByEndereco(String endereco){
        return repository.findByEnderecoIgnoreCase(endereco);
    }

    public List<Fornecedor> getByTelefone(String telefone){
        return repository.findByTelefone(telefone);
    }

    public void deleteFornecedorByNome(String nome){
        repository.deleteByNome(nome);
    }
}
