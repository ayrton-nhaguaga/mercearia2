package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.ProductDTO;
import com.mercearia.mercearia.model.Product;
import com.mercearia.mercearia.model.Category;
import com.mercearia.mercearia.repository.ProductRepository;
import com.mercearia.mercearia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(String category, ProductDTO pDTO) {
        List<Category> categories = categoryRepository.findByCategoryIgnoreCase(category);
        if (categories.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada: " + category);
        }
        Category cat = categories.get(0);

        Product product = new Product();
        product.setName(pDTO.getName());
        product.setPrice(Double.parseDouble(pDTO.getPrice())); // conversão de String para double
        product.setCategory(cat);

        return productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public List<Product> getByNameContainingIgnoreCase(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getByCategoryContainingIgnoreCase(String category){
        return productRepository.findByCategoryIgnoreCase(category);
    }

    public List<Product> getByPrice(double price){
        return productRepository.findByPrice(price);
    }

    public List<Product> updateProduct(String name, ProductDTO dto) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        List<Category> categories = categoryRepository.findByCategoryIgnoreCase(dto.getCategory());

        if (categories.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada: " + dto.getCategory());
        }

        Category category = categories.get(0);

        for (Product p : products) {
            p.setName(dto.getName());
            p.setCategory(category);
            p.setPrice(Double.parseDouble(dto.getPrice()));  // conversão de String para double
            productRepository.save(p);
        }

        return products;
    }

    public boolean deleteProduct(String name){
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        if (!products.isEmpty()){
            productRepository.deleteAll();
            return true;
        }
        return  false;
    }


}
