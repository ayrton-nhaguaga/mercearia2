package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.CategoriaDTO;
import com.mercearia.mercearia.repository.CategoriaRepository;
import com.mercearia.mercearia.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria createCategoria (CategoriaDTO dto){
        Categoria service = new Categoria();
        service.setCategoria(dto.getCategoria());
        return repository.save(service);
    }

    public List<Categoria> getAllCategorias(){
        return repository.findAll();
    }

    public List<Categoria> getCategoriaByCategoria(String categoria){
        return repository.findByCategoria(categoria);
    }

    public  void  deleteCategoria (String categoria){
        repository.deleteByCategoria(categoria);
    }
}
