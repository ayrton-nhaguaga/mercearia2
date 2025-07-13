package com.mercearia.mercearia.controller;

import com.mercearia.mercearia.dto.FornecedorDTO;
import com.mercearia.mercearia.model.Fornecedor;
import com.mercearia.mercearia.model.Funcionario;
import com.mercearia.mercearia.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> createFonecedor(@RequestBody FornecedorDTO dto){
        Fornecedor fornecedor = fornecedorService.createFornecedor(dto);
        return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAllFornecedor(){
        List<Fornecedor> fornecedores = fornecedorService.getAllFornecedores();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Fornecedor>> getFornecedorByNome(@RequestParam String nome){
        List<Fornecedor> fornecedores = fornecedorService.getByNomeIgnoreCase(nome);
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/telefone")
    public ResponseEntity<List<Fornecedor>> getFornecedorByTelefone(@RequestParam String telefone){
        List<Fornecedor> fornecedores = fornecedorService.getByTelefone(telefone);
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Fornecedor>> getFornecedorByCategoria(@RequestParam String categoria){
        List<Fornecedor> fornecedores = fornecedorService.getByCategoria(categoria);
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/endereco")
    public ResponseEntity<List<Fornecedor>> getFornecedoresByEndereco(@RequestParam String endereco){
        List<Fornecedor> fornecedores = fornecedorService.getByEndereco(endereco);
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @PutMapping("/nome")
    public ResponseEntity<List<Fornecedor>> updateFornecedorByName(@RequestParam String nome, @RequestBody FornecedorDTO dto){
        List<Fornecedor> updatedList = fornecedorService.updateFornecedor(nome, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteFornecedorByName(@RequestParam String nome){
        if(fornecedorService.deleteFornecedor(nome)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
