package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.CategoriaDTO;
import com.mercearia.mercearia.dto.ProdutoDTO;
import com.mercearia.mercearia.model.Produto;
import com.mercearia.mercearia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestParam String categoria, @RequestBody ProdutoDTO dto){
        Produto produto = produtoService.createProduto(categoria,dto);
        return  new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos(){
        List<Produto> produtos = produtoService.getAllProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Produto>> getByNomeContainingIgnoreCase(@RequestParam String nome){
        List<Produto> produtos = produtoService.getByNomeContainingIgnoreCase(nome);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Produto>> getByCategoriaContainingIgnoreCase(@RequestParam String categoria){
        List<Produto> produtos = produtoService.getByCategoriaContainingIgnoreCase(categoria);
        return  new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/preco")
    public ResponseEntity<List<Produto>> getByPreco(@RequestParam double preco){
        List<Produto> produtos = produtoService.getBypreco(preco);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping("/nome")
    public ResponseEntity<List<Produto>> updateProduto(@RequestParam String nome, @RequestBody ProdutoDTO dto){
        List<Produto> updatedList = produtoService.updateProduto(nome, dto);

        if(updatedList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteProduto(@RequestParam String nome){
        if (produtoService.deleteProduto(nome)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
