package com.example.estudo.model;

import com.example.estudo.enums.ProdutoEnum;
import jakarta.persistence.*;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "preco_produto")
    private Double preco;

    @Column(name = "categoria_produto")
    private ProdutoEnum categoria;

    public Produto() {}

    public Produto(String nome, Double preco, ProdutoEnum categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ProdutoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(ProdutoEnum categoria) {
        this.categoria = categoria;
    }
}
