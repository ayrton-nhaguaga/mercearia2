package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.FuncionarioDTO;
import com.mercearia.mercearia.model.Funcionario;
import com.mercearia.mercearia.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario createFuncionario(FuncionarioDTO dto){
        Funcionario service = new Funcionario();
        service.setNome(dto.getNome());
        service.setEndereco(dto.getEndereco());
        service.setTelefone(dto.getTelefone());
        service.setEmail(dto.getEmail());
        return repository.save(service);
    }

    public List<Funcionario> getAllFuncionarios(){
        return repository.findAll();
    }

    public List<Funcionario> getByNomeContainingIgnoreCase(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Funcionario> getByTelefone(String telefone){
        return repository.findByTelefone(telefone);
    }

    public List<Funcionario> getByEndereco(String endereco){
        return repository.findByEndereco(endereco);
    }

    public List<Funcionario> getByEmail(String email){
        return repository.findByEmail(email);
    }

    public void deleteByNome(String nome){
        repository.deleteByNome(nome);
    }

}
