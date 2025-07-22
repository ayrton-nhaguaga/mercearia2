package com.ayrton.mercearia.controller;

import com.ayrton.mercearia.dto.StockDTO;
import com.ayrton.mercearia.model.Stock;
import com.ayrton.mercearia.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestParam String name , @RequestParam StockDTO dto, @RequestParam int quantity){
        Stock stock = stockService.createStock(name, dto, quantity);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAll(){
        List<Stock> stocks = stockService.getAll();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/quantity_less_than")
    public ResponseEntity<List<Stock>> getByQuantityLessThan(@RequestParam int quantity){
        List<Stock> stocks = stockService.getByQuantityLessThan(quantity);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/Product_PriceBetween")
    public ResponseEntity<List<Stock>> getByProductPriceBetween(@RequestParam double min, @RequestParam double max){
        List<Stock> stocks = stockService.getByProductPriceBetween(min, max);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Stock>> getByProductName(@RequestParam String name){
        List<Stock> stocks = stockService.getByProductName(name);
        return  new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Stock>> updateStockByName(@RequestParam String name, StockDTO dto){
        List<Stock> updatedList = stockService.updateStock(name, dto);

        if (updatedList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteStock(@RequestParam String name){
        if (stockService.deleteStock(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
