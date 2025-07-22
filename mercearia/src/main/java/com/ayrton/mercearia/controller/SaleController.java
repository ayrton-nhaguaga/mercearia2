package com.ayrton.mercearia.controller;

import com.ayrton.mercearia.model.Sale;
import com.ayrton.mercearia.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    /**
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestParam String productName, @RequestBody StockDTO eDto, @RequestBody SaleDTO vDto, @RequestParam int quantitySold, @RequestParam String funcionario, @RequestParam LocalDateTime data){
        Sale sale = saleService.createVenda(nomeProduto, eDto, vDto, quantidadeVendida, funcionario, data);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }
     */

    @GetMapping
    public ResponseEntity<List<Sale>> getAllVendas(){
        List<Sale> sales = saleService.getAll();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/date_soldBetween")
    public ResponseEntity<List<Sale>> getBySaleDateBetween(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end){
        List<Sale> sales = saleService.getBySaleDateBetween(start, end);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/sold_date")
    public ResponseEntity<List<Sale>> getBySaleDate(@RequestParam LocalDateTime date){
        List<Sale> sales = saleService.getBySaleDate(date);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/item_sold")
    public ResponseEntity<List<Sale>> getByItemSoldNameIgnoreCase(@RequestParam String itemSold){
        List<Sale> sales = saleService.getByItemSoldNameIgnoreCase(itemSold);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/quantity")
    public ResponseEntity<List<Sale>> getByQuantity(@RequestParam int quantity){
        List<Sale> sales = saleService.getByQuantity(quantity);
        return  new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/supplier-name")
    public ResponseEntity<List<Sale>> getBySupplierNameIgnoreCase(@RequestParam String name){
        List<Sale> sales = saleService.getBySupplierNameIgnoreCase(name);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
}
