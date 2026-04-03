package com.example.estudo_crud.service;

import com.example.estudo_crud.model.User;
import com.example.estudo_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return repository.findAll();
    }

    public Optional<User> listById(Long id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(User user, Long id) {
        User antigo = repository.findById(id).get();

        antigo.setRole(user.getRole());
        antigo.setName(user.getName());
        antigo.setEmail(user.getEmail());
        antigo.setBirthDate(user.getBirthDate());

        return repository.save(antigo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
