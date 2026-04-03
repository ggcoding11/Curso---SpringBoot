package com.example.estudo_crud.controller;

import com.example.estudo_crud.model.User;
import com.example.estudo_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        List<User> request = service.listAll();

        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listById(@PathVariable Long id) {
        User request = service.listById(id).get();

        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User request = service.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        User request = service.update(user, id);

        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}