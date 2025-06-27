package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.CategoriaDTO;
import com.mercearia.mercearia.model.Categoria;
import com.mercearia.mercearia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria criarCategoria(CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setCategoria(dto.getCategoria());
        return repository.save(categoria);
    }

    public List<Categoria> retornarTodasCategorias(){
        return repository.findAll();
    }

    public List<Categoria> retornarCategoriaPelaCategoria(String categoria){
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    public List<Categoria> atualizarCategoriaPelaCategoria(String categoria, CategoriaDTO dto){
        List<Categoria> existentes = repository.findByCategoriaIgnoreCase(categoria);
        for (Categoria c : existentes){
            c.setCategoria(dto.getCategoria());
            repository.save(c);
        }
        return existentes;
    }

    public boolean apagarCategoriaPelaCategoria(String categoria){
        List<Categoria> categorias = repository.findByCategoriaIgnoreCase(categoria);
        if (!categorias.isEmpty()) {
            repository.deleteAll(categorias);
            return true;
        }
        return false;
    }
}
