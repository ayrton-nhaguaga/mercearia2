package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.EstoqueDTO;
import com.mercearia.mercearia.dto.VendaDTO;
import com.mercearia.mercearia.model.Estoque;
import com.mercearia.mercearia.model.Produto;
import com.mercearia.mercearia.model.Venda;
import com.mercearia.mercearia.repository.EstoqueRepository;
import com.mercearia.mercearia.repository.ProdutoRepository;
import com.mercearia.mercearia.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Venda createVenda(String nomeProduto, EstoqueDTO eDto, VendaDTO vDto, int quantidadeVendida, String funcionario, LocalDateTime data) {
        // Verifica se tem produto no estoque suficiente
        if (eDto.getQuantidade() < quantidadeVendida) {
            throw new RuntimeException("Quantidade indisponível: " + quantidadeVendida);
        }

        // Verifica se o produto existe
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nomeProduto);
        if (produtos.isEmpty()) {
            throw new RuntimeException("Produto não encontrado: " + nomeProduto);
        }

        Produto pd = produtos.get(0);

        // Busca estoque relacionado ao produto
        List<Estoque> estoques = estoqueRepository.findByProduto(pd);
        if (estoques.isEmpty()) {
            throw new RuntimeException("Estoque não encontrado para o produto: " + nomeProduto);
        }

        Estoque es = estoques.get(0);

        // Atualiza o estoque
        es.setQuantidade(es.getQuantidade() - quantidadeVendida);
        estoqueRepository.save(es);

        // Cria e salva a venda
        Venda venda = new Venda();
        venda.setDataVenda(data);
        venda.setQuantidadeVendida(quantidadeVendida);
        venda.setItemVendido(pd);
        venda.setFuncionario(funcionario);

        return vendaRepository.save(venda);
    }

    public List<Venda> getAllVendas(){
        return vendaRepository.findAll();
    }

    public List<Venda> getByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim){
        return vendaRepository.findByDataVendaBetween(inicio, fim);
    }

    public List<Venda> getByDataDaVenda(LocalDateTime data){
        return vendaRepository.findByDataVenda(data);
    }

    public List<Venda> getByItemVendidoIngoreCase(String itemVendido){
        return vendaRepository.findByItemVendidoIgnoreCase(itemVendido);
    }

    public List<Venda> getByQuantidade(int quantidade){
        return vendaRepository.findByQuantidadeVendida(quantidade);
    }

    public List<Venda> getByFuncionarioIgnoreCase(String funcionario){
        return vendaRepository.findByFuncionarioIgnoreCase(funcionario);
    }

}
