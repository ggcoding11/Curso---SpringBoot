package com.bn.demo.controllers;

import com.bn.demo.models.EstudanteModel;
import com.bn.demo.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel> > findAll(){
          List<EstudanteModel> requeste = estudanteService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <EstudanteModel> criarPessoa(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel requeste = estudanteService.criarPessoa(estudanteModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estudanteModel.getId()).toUri();

        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        estudanteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<EstudanteModel> buscarId(@PathVariable Long id){
        return  estudanteService.buscarid(id);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizar(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel){
        return estudanteService.atualizar(id,estudanteModel);
    }
}
