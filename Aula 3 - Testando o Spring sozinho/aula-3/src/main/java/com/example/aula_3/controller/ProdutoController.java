package com.example.aula_3.controller;

import com.example.aula_3.model.ProdutoModel;
import com.example.aula_3.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoService.buscarPeloId(id);
    }

    @PostMapping
    public ProdutoModel salvarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping
    public void deletarProduto(ProdutoModel produto) {
        produtoService.deletarProduto(produto);
    }
}
