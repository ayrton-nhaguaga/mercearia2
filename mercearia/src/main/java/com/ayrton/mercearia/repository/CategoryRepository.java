package com.ayrton.mercearia.repository;

import com.ayrton.mercearia.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Override
    List<Category> findAll();


    List<Category> findByCategoryIgnoreCase(String category);

    List<Category> findCategoriaById(String id);

}

