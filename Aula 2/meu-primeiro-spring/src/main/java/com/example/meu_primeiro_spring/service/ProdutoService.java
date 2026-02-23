package com.example.meu_primeiro_spring.service;

import com.example.meu_primeiro_spring.model.Produto;
import com.example.meu_primeiro_spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById((id));
    }

    public Produto salvarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }
}
