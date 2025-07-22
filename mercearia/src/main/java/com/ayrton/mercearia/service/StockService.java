package com.ayrton.mercearia.service;


import com.ayrton.mercearia.dto.StockDTO;
import com.ayrton.mercearia.model.Stock;
import com.ayrton.mercearia.model.Product;
import com.ayrton.mercearia.repository.StockRepository;
import com.ayrton.mercearia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public Stock createStock(String name, StockDTO eDto, int quantity){
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        if (products.isEmpty()){
            throw new RuntimeException("Produto não encontrado: " +name);
        }
        Product prod = products.get(0);
        Stock stock = new Stock();
        stock.setProduct(prod);
        stock.setQuantity(eDto.getQuantity());

        return stockRepository.save(stock);
    }

    public List<Stock> getAll(){
       return stockRepository.findAll();
    }

    public List<Stock> getByQuantityLessThan(int quantity){
        return stockRepository.findByQuantityLessThan(quantity);
    }

    public List<Stock> getByProductPriceBetween(double min, double max){
        return stockRepository.findByProductPriceBetween(min, max);
    }

    public List<Stock> getByProductName(String name){
        return stockRepository.findByProductName(name);
    }

    public List<Stock> updateStock(String name, StockDTO dto){
        List<Stock> stocks = stockRepository.findByProductName(name);
        for (Stock s : stocks){
            s.setQuantity(dto.getQuantity());
            s.setProduct(dto.getProduct());
            stockRepository.save(s);
        }
        return stocks;
    }

    public boolean deleteStock(String name){
        List<Stock> stocks = stockRepository.findByProductName(name);

        if (!stocks.isEmpty()) {
            stockRepository.deleteAll();
            return true;
        }
        return false;

    }
}
