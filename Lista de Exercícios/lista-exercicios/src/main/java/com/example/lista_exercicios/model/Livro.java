package com.example.lista_exercicios.model;

import jakarta.persistence.*;

@Entity
@Table(name="tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="coluna_titulo")
    private String titulo;

    @Column(name="coluna_autor")
    private String autor;

    @Column(name="coluna_ano_publicacao")
    private Integer anoPublicacao;

    public Livro() {

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
