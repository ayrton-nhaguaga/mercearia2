package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.FuncionarioDTO;
import com.mercearia.mercearia.model.Funcionario;
import com.mercearia.mercearia.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody FuncionarioDTO dto){
        Funcionario funcionario = funcionarioService.createFuncionario(dto);
        return  new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
        List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Funcionario>> getFuncionarioByName(@RequestParam String nome){
        List<Funcionario> funcionarios = funcionarioService.getByNomeContainingIgnoreCase(nome);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/telefone")
    public ResponseEntity<List<Funcionario>> getFuncionarioByTelefone(@RequestParam String telefone){
        List<Funcionario> funcionarios = funcionarioService.getByTelefone(telefone);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/endereco")
    public ResponseEntity<List<Funcionario>> getFuncionarioByendereco(@RequestParam String endereco){
        List<Funcionario> funcionarios = funcionarioService.getByEndereco(endereco);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<Funcionario>> getFuncionarioByemail(@RequestParam String email){
        List<Funcionario> funcionarios = funcionarioService.getByEmail(email);
        return  new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PutMapping("/nome")
    public ResponseEntity<List<Funcionario>> updateFuncionario(@RequestParam String nome, @RequestBody FuncionarioDTO dto){
        List<Funcionario> updatedList = funcionarioService.updateFuncionario(nome, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteFuncionarioByNome(@RequestParam String nome){
        if(funcionarioService.deleteFuncionario(nome)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
