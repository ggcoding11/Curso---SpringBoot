package com.example.aula_4.controller;

import com.example.aula_4.model.Estudante;
import com.example.aula_4.repository.EstudanteRepository;
import com.example.aula_4.service.EstudanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    private final EstudanteService service;

    public EstudanteController(EstudanteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudante> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> listarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudante salvarEstudante(@RequestBody Estudante e) {
        return service.salvarEstudante(e);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        service.deletarEstudante(id);
    }

}
