package com.mercearia.mercearia.controller;

import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.dto.VendaDTO;
import com.mercearia.mercearia.model.Venda;
import com.mercearia.mercearia.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestParam String nomeProduto, @RequestBody EstoqueDTO eDto, @RequestBody VendaDTO vDto, @RequestParam int quantidadeVendida, @RequestParam String funcionario, @RequestParam LocalDateTime data){
        Venda venda = vendaService.createVenda(nomeProduto, eDto, vDto, quantidadeVendida, funcionario, data);
        return new ResponseEntity<>(venda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas(){
        List<Venda> vendas = vendaService.getAllVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/data_vendaBetween")
    public ResponseEntity<List<Venda>> getByDataVendaBetween(@RequestParam LocalDateTime inicio, @RequestParam LocalDateTime fim){
        List<Venda> vendas = vendaService.getByDataVendaBetween(inicio, fim);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/data_venda")
    public ResponseEntity<List<Venda>> getByDataVenda(@RequestParam LocalDateTime data){
        List<Venda> vendas = vendaService.getByDataDaVenda(data);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/item_vendido")
    public ResponseEntity<List<Venda>> getByItemVendido(@RequestParam String itemVendido){
        List<Venda> vendas = vendaService.getByItemVendidoIngoreCase(itemVendido);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/quantidade")
    public ResponseEntity<List<Venda>> getByQuantidade(@RequestParam int quantidade){
        List<Venda> vendas = vendaService.getByQuantidade(quantidade);
        return  new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<Venda>> getByFuncionario(@RequestParam String funcionario){
        List<Venda> vendas = vendaService.getByFuncionarioIgnoreCase(funcionario);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }
}
