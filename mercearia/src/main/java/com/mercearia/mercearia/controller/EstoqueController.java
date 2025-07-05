package com.mercearia.mercearia.controller;

import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.model.Estoque;
import com.mercearia.mercearia.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<Estoque> createEstoque(@RequestParam String nome ,@RequestParam EstoqueDTO dto, @RequestParam int quantidade){
        Estoque estoque = estoqueService.createEstoque(nome, dto, quantidade);
        return new ResponseEntity<>(estoque, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> getAllEstoques(){
        List<Estoque> estoques = estoqueService.getAllEstoque();
        return new ResponseEntity<>(estoques, HttpStatus.OK);
    }

    @GetMapping("/quantidade_less_than")
    public ResponseEntity<List<Estoque>> getEstoquegetByQuantidadeLessThan(@RequestParam int quantidade){
        List<Estoque> estoques = estoqueService.getByQuantidadeLessThan(quantidade);
        return new ResponseEntity<>(estoques, HttpStatus.OK);
    }

    @GetMapping("/Produto_PrecoBetween")
    public ResponseEntity<List<Estoque>> getByProduto_PrecoBetween(@RequestParam double min, @RequestParam double max){
        List<Estoque> estoques = estoqueService.getByProduto_PrecoBetween(min, max);
        return new ResponseEntity<>(estoques, HttpStatus.OK);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Estoque>> getByProdutoName(@RequestParam String nome){
        List<Estoque> estoques = estoqueService.getByProdutoName(nome);
        return  new ResponseEntity<>(estoques, HttpStatus.OK);
    }

    @PutMapping("/nome")
    public ResponseEntity<List<Estoque>> updateEstoqueByName(@RequestParam String nome, EstoqueDTO dto){
        List<Estoque> updatedList = estoqueService.updateEstoque(nome, dto);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/nome")
    public ResponseEntity<Void> deleteEstoque(@RequestParam String nome){
        if (estoqueService.deleteEstoque(nome)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
