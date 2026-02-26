package com.example.aula_4.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_aluno")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_aluno")
    private Long id;

    @Column(name="nome_aluno")
    private String nome;

    @Column(name="email_aluno")
    private String email;

    @Column(name="idade_aluno")
    private Integer idade;

    public Estudante() {}

    public Estudante(String nome, String email, Integer idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
