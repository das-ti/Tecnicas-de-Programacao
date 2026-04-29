package com.mylabsystems.jpa.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "categoria", length = 50, nullable = false)
    private String categoria;
    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;
    @Column(name = "em_promocao")
    private boolean emPromocao;

    public Receita() {
    }

    public Receita(String nome, String categoria, BigDecimal preco, boolean emPromocao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.emPromocao = emPromocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    @Override
    public String toString() {
        return "Receita [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco
                + ", emPromocao=" + emPromocao + "]";
    }
}
