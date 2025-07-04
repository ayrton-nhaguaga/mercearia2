package com.mercearia.mercearia.service;


import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.dto.ProdutoDTO;
import com.mercearia.mercearia.model.Estoque;
import com.mercearia.mercearia.model.Produto;
import com.mercearia.mercearia.repository.EstoqueRepository;
import com.mercearia.mercearia.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Estoque createEstoque(String nome, EstoqueDTO eDto, int quantidade){
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        if (produtos.isEmpty()){
            throw new RuntimeException("Produto não encontrado: " +nome);
        }
        Produto prod = produtos.get(0);
        Estoque estoque = new Estoque();
        estoque.setProduto(prod);
        estoque.setQuantidade(eDto.getQuantidade());

        return estoqueRepository.save(estoque);
    }

    public List<Estoque> getAllEstoque(){
       return estoqueRepository.findAll();
    }

    public List<Estoque> getByQuantidadeLessThan(int quantidade){
        return estoqueRepository.findByQuantidadeLessThan(quantidade);
    }

    public List<Estoque> getByProduto_PrecoBetween(double min, double max){
        return estoqueRepository.findByProduto_PrecoBetween(min, max);
    }

    public List<Estoque> getByProdutoName(String nome){
       List<Produto> produto = produtoRepository.findByNomeContainingIgnoreCase(nome);
       Produto pd = produto.get(0);

       return estoqueRepository.findByProduto(pd);
    }

    public List<Estoque> updateEstoque(String nome, EstoqueDTO dto){
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        Produto pd = produtos.get(0);

        List<Estoque> estoques = estoqueRepository.findByProduto(pd);

        if (estoques.isEmpty()) {
            throw new RuntimeException("Estoque não encontrado: " + nome);
        }

        for (Estoque e : estoques ){
            e.setQuantidade(dto.getQuantidade());
            e.setProduto(dto.getProduto());
            estoqueRepository.save(e);
        }
        return estoques;
    }

    public boolean deleteEstoque(String nome){
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        Produto pd = produtos.get(0);

        List<Estoque> estoques = estoqueRepository.findByProduto(pd);
        Estoque e = estoques.get(0);

        if (!estoques.isEmpty()) {
            estoqueRepository.delete(e);
            return true;
        }
        return false;

    }
}
