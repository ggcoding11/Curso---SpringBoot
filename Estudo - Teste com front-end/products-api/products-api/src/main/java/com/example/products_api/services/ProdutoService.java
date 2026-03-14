package com.example.products_api.services;

import com.example.products_api.models.ProdutoModel;
import com.example.products_api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> listarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public ProdutoModel cadastrar(ProdutoModel p) {
        return repository.save(p);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel p) {
        ProdutoModel antigo = repository.findById(id).get();

        antigo.setNome(p.getNome());
        antigo.setPreco(p.getPreco());
        antigo.setQuantidade(p.getQuantidade());

        return repository.save(antigo);
    }
}
