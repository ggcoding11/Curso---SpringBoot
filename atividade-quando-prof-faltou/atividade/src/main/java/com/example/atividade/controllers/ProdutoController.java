package com.example.atividade.controllers;

import com.example.atividade.models.ProdutoModel;
import com.example.atividade.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public ProdutoModel salvarProduto(@RequestBody ProdutoModel p) {
        return service.salvar(p);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel p) {
        return service.atualizar(id, p);
    }
}
