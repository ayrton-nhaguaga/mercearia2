package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.CategoryDTO;
import com.mercearia.mercearia.model.Category;
import com.mercearia.mercearia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategoria(@RequestBody CategoryDTO dto){
        Category category = categoryService.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorias(){
        List<Category> categories = categoryService.getAllCategories();
        return  new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getByCategoria(@RequestParam String category){
        List<Category> categories = categoryService.getByCategory(category);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Category>> uptdateCategoria(@RequestParam String category, @RequestBody CategoryDTO dto) {
        List<Category> updatedList = categoryService.updateByCategory(category, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteCategoriaByCategoria(@RequestParam String category){
        if (categoryService.deleteByCategory(category)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
