package com.mercearia.mercearia.service;

import com.mercearia.mercearia.dto.ProdutoDTO;
import com.mercearia.mercearia.model.Produto;
import com.mercearia.mercearia.model.Categoria;
import com.mercearia.mercearia.repository.ProdutoRepository;
import com.mercearia.mercearia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto createProduto(String categoria, ProdutoDTO pDTO) {
        List<Categoria> categorias = categoriaRepository.findByCategoriaIgnoreCase(categoria);
        if (categorias.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada: " + categoria);
        }
        Categoria cat = categorias.get(0);

        Produto produto = new Produto();
        produto.setNome(pDTO.getNome());
        produto.setPreco(Double.parseDouble(pDTO.getPreco())); // conversão de String para double
        produto.setCategoria(cat);

        return produtoRepository.save(produto);
    }

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    public List<Produto> getByNomeContainingIgnoreCase(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Produto> getByCategoriaContainingIgnoreCase(String categoria){
        return produtoRepository.findByCategoriaIgnoreCase(categoria);
    }

    public List<Produto> getBypreco(double preco){
        return produtoRepository.findByPreco(preco);
    }

    public List<Produto> updateProduto(String nome, ProdutoDTO dto) {
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        List<Categoria> categorias = categoriaRepository.findByCategoriaIgnoreCase(dto.getCategoria());

        if (categorias.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada: " + dto.getCategoria());
        }

        Categoria categoria = categorias.get(0);

        for (Produto p : produtos) {
            p.setNome(dto.getNome());
            p.setCategoria(categoria);
            p.setPreco(Double.parseDouble(dto.getPreco()));  // conversão de String para double
            produtoRepository.save(p);
        }

        return produtos;
    }

    public boolean deleteProduto(String nome){
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        if (!produtos.isEmpty()){
            produtoRepository.deleteAll();
            return true;
        }
        return  false;
    }


}
