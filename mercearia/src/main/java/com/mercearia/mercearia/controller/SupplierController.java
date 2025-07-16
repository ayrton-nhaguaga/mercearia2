package com.mercearia.mercearia.controller;

import com.mercearia.mercearia.dto.SupplierDTO;
import com.mercearia.mercearia.model.Supplier;
import com.mercearia.mercearia.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> createFonecedor(@RequestBody SupplierDTO dto){
        Supplier supplier = supplierService.createSupplier(dto);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllFornecedor(){
        List<Supplier> suppliers = supplierService.getAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Supplier>> getByName(@RequestParam String name){
        List<Supplier> suppliers = supplierService.getByNameIgnoreCase(name);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/telephone")
    public ResponseEntity<List<Supplier>> getByTelephone(@RequestParam String telephone){
        List<Supplier> suppliers = supplierService.getByTelephone(telephone);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Supplier>> getByCategory(@RequestParam String category){
        List<Supplier> suppliers = supplierService.getByCategory(category);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Supplier>> getFornecedoresByEndereco(@RequestParam String address){
        List<Supplier> suppliers = supplierService.getByAddress(address);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Supplier>> updateByName(@RequestParam String name, @RequestBody SupplierDTO dto){
        List<Supplier> updatedList = supplierService.updateSupplier(name, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteByName(@RequestParam String name){
        if(supplierService.deleteSupplier(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
