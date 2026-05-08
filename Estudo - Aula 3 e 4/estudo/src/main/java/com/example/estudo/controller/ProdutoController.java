package com.example.estudo.controller;

import com.example.estudo.enums.ProdutoEnum;
import com.example.estudo.model.Produto;
import com.example.estudo.service.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto p) {
        Produto request = service.salvar(p);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(p.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> request = service.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Produto> listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto p) {
        return service.atualizar(id, p);
    }
}