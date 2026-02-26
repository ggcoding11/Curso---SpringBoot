package com.example.aula_4.service;

import com.example.aula_4.model.Estudante;
import com.example.aula_4.repository.EstudanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {
    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante salvarEstudante(Estudante e) {
        return repository.save(e);
    }

    public List<Estudante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Estudante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletarEstudante(Long id) {
        repository.deleteById(id);
    }
}
