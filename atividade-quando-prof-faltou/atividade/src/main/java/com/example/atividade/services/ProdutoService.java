package com.example.atividade.services;

import com.example.atividade.models.ProdutoModel;
import com.example.atividade.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoModel> listarPorId(Long id){
        return repository.findById(id);
    }

    public ProdutoModel salvar(ProdutoModel p) {
        return repository.save(p);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel novo){
        ProdutoModel antigo = repository.findById(id).get();

        antigo.setNome(novo.getNome());
        antigo.setPreco(novo.getPreco());
        antigo.setQuantidadeEmEstoque(novo.getQuantidadeEmEstoque());
        antigo.setStatus(novo.getStatus());

        return repository.save(antigo);
    }
}
