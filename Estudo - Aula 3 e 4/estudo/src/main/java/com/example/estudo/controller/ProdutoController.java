package com.example.estudo.controller;

import com.example.estudo.model.Produto;
import com.example.estudo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto p) {
        return service.salvar(p);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Produto> listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable Long id) {
        service.deletar(id);
    }
}
