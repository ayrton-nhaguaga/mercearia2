package com.mercearia.mercearia.service;


import com.mercearia.mercearia.dto.CategoriaDTO;
import com.mercearia.mercearia.model.Categoria;
import com.mercearia.mercearia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria criarCategoria(CategoriaDTO dto){
        Categoria service = new Categoria();
        service.setCategoria(dto.getCategoria());
        return repository.save(service);
    }

    List<Categoria> retornarTodasCategorias(){
        return repository.findAll();
    }

    public List<Categoria> retornarCategoriaPeloId(String id){
        return  repository.findCategoriaById(id);
    }

    public List<Categoria> retornarCategoriaPelaCategoria(String categoria){
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    public List<Categoria> atualizarCategoriaPelaCategoria(String categoria, CategoriaDTO dto){
        List<Categoria> existe = repository.findByCategoriaIgnoreCase(categoria);
        for (Categoria service : existe){
            service.setCategoria(dto.getCategoria());
            repository.save(service);
        }
        return existe;
    }

    public boolean apagarCategoriaPelaCategoria(String categoria){
        List<Categoria> services = repository.findByCategoriaIgnoreCase(categoria);
        if (!services.isEmpty()) {
            repository.deleteAll(services);
            return true;
        }
        return false;
    }
}
