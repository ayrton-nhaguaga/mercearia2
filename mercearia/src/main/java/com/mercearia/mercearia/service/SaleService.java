package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.StockDTO;
import com.mercearia.mercearia.dto.SaleDTO;
import com.mercearia.mercearia.dto.SupplierDTO;
import com.mercearia.mercearia.model.Stock;
import com.mercearia.mercearia.model.Product;
import com.mercearia.mercearia.model.Sale;
import com.mercearia.mercearia.repository.StockRepository;
import com.mercearia.mercearia.repository.ProductRepository;
import com.mercearia.mercearia.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    public Sale createVenda(String productName, StockDTO eDto, SaleDTO vDto, int quantitySold, SupplierDTO sDTO, LocalDateTime data) {
        // Verifica se tem produto no estoque suficiente
        if (eDto.getQuantity() < quantitySold) {
            throw new RuntimeException("Quantidade indisponível: " + quantitySold);
        }

        // Verifica se o produto existe
        List<Stock> stocks = stockRepository.findByProductName(productName);
        if (stocks.isEmpty()) {
            throw new RuntimeException("Estoque não encontrado para o produto: " + productName);
        }

        List<Product> products = productRepository.findByNameContainingIgnoreCase(productName);
        Product pd = products.get(0);


        Stock es = stocks.get(0);

        // Atualiza o estoque
        es.setQuantity(es.getQuantity() - quantitySold);
        stockRepository.save(es);

        // Cria e salva a venda
        Sale sale = new Sale();
        sale.setSaleDate(data);
        sale.setQuantitySold(quantitySold);
        sale.setItemSold(pd);
        // falta set de funcionario

        return saleRepository.save(sale);
    }

    public List<Sale> getAll(){
        return saleRepository.findAll();
    }

    public List<Sale> getBySaleDateBetween(LocalDateTime start, LocalDateTime end){
        return saleRepository.findBySaleDateBetween(start, end);
    }

    public List<Sale> getBySaleDate(LocalDateTime date){
        return saleRepository.findBySaleDate(date);
    }

    public List<Sale> getByItemSoldNameIgnoreCase(String name){
        return saleRepository.findByItemSoldNameIgnoreCase(name);
    }

    public List<Sale> getByQuantity(int quantity){
        return saleRepository.findByQuantitySold(quantity);
    }

    public List<Sale> getBySupplierNameIgnoreCase(String name){
        return saleRepository.findBySupplierNameIgnoreCase(name);
    }

}
