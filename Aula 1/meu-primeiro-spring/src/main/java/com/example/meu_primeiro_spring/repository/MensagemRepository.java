package com.example.meu_primeiro_spring.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
    public String obterMensagem() {
        return "Olá do repositório!";
    }
}
