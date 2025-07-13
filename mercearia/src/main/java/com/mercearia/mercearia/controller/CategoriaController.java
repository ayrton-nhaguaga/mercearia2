package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.CategoriaDTO;
import com.mercearia.mercearia.model.Categoria;
import com.mercearia.mercearia.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody CategoriaDTO dto){
        Categoria categoria = categoriaService.criarCategoria(dto);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categorias = categoriaService.getTodasCategorias();
        return  new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> getByCategoria(@RequestParam String categoria){
        List<Categoria> categorias = categoriaService.getByCategoriaPelaCategoria(categoria);
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @PutMapping("/nome")
    public ResponseEntity<List<Categoria>> uptdateCategoria(@RequestParam String categoria, @RequestBody CategoriaDTO dto) {
        List<Categoria> updatedList = categoriaService.updateCategoriaPelaCategoria(categoria, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteCategoriaByCategoria(@RequestParam String categoria){
        if (categoriaService.deleteCategoriaPelaCategoria(categoria)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
