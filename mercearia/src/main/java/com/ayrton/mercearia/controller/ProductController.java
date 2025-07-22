package com.ayrton.mercearia.controller;


import com.ayrton.mercearia.dto.ProductDTO;
import com.ayrton.mercearia.model.Product;
import com.ayrton.mercearia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduto(@RequestParam String category, @RequestBody ProductDTO dto){
        Product product = productService.createProduct(category,dto);
        return  new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProdutos(){
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Product>> getByNameContainingIgnoreCase(@RequestParam String name){
        List<Product> products = productService.getByNameContainingIgnoreCase(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getByCategoryContainingIgnoreCase(@RequestParam String category){
        List<Product> products = productService.getByCategoryContainingIgnoreCase(category);
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getByPrice(@RequestParam double price){
        List<Product> products = productService.getByPrice(price);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Product>> updateProduct(@RequestParam String name, @RequestBody ProductDTO dto){
        List<Product> updatedList = productService.updateProduct(name, dto);

        if(updatedList.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteProduct(@RequestParam String name){
        if (productService.deleteProduct(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
