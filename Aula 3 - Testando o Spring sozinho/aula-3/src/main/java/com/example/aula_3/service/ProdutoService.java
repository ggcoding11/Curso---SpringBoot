package com.example.aula_3.service;

import com.example.aula_3.model.ProdutoModel;
import com.example.aula_3.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel salvarProduto(ProdutoModel produto) {
       return produtoRepository.save(produto);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPeloId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel p) {
        ProdutoModel antigo = produtoRepository.findById(id).get();

        antigo.setNome(p.getNome());
        antigo.setPreco(p.getPreco());

        return antigo;
    }
}