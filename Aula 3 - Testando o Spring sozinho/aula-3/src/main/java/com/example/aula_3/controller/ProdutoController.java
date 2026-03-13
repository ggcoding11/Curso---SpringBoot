package com.example.aula_3.controller;

import com.example.aula_3.model.ProdutoModel;
import com.example.aula_3.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        List<ProdutoModel> request = produtoService.listarProdutos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPeloId(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> salvarProduto(@RequestBody ProdutoModel produto) {
        ProdutoModel request = produtoService.salvarProduto(produto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel p) {
        return produtoService.atualizarProduto(id, p);
    }
}
