package com.example.estudo.service;

import com.example.estudo.model.Produto;
import com.example.estudo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto p) {
        return repository.save(p);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Optional<Produto> listarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
