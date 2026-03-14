package com.example.products_api.controllers;

import com.example.products_api.models.ProdutoModel;
import com.example.products_api.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoModel> listarProdutos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @PostMapping
    public ProdutoModel cadastrarProduto(@RequestBody ProdutoModel p){
        return service.cadastrar(p);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel p){
        return service.atualizar(id, p);
    }
}