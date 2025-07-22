package com.ayrton.mercearia.service;

import com.ayrton.mercearia.dto.CategoryDTO;
import com.ayrton.mercearia.model.Category;
import com.ayrton.mercearia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category createCategory(CategoryDTO dto){
        Category category = new Category();
        category.setCategory(dto.getCategory());
        return repository.save(category);
    }

    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    public List<Category> getByCategory(String category){
        return repository.findByCategoryIgnoreCase(category);
    }

    public List<Category> updateByCategory(String category, CategoryDTO dto){
        List<Category> exists = repository.findByCategoryIgnoreCase(category);
        for (Category c : exists){
            c.setCategory(dto.getCategory());
            repository.save(c);
        }
        return exists;
    }

    public boolean deleteByCategory(String category){
        List<Category> categories = repository.findByCategoryIgnoreCase(category);
        if (!categories.isEmpty()) {
            repository.deleteAll(categories);
            return true;
        }
        return false;
    }
}
