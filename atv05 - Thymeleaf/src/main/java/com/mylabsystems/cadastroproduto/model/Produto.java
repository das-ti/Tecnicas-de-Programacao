package com.mylabsystems.cadastroproduto.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull; 

public class Produto {

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String nome;

    @NotNull(message = "O preço do produto é obrigatório.")
    @Min(value = 0, message = "O preço não pode ser menor que zero.")
    private double preco;

    @NotNull(message = "Selecione a categoria do produto.")
    private String categoria;

    @NotNull(message = "Informe a quantidade em estoque.")
    @Min(value = 0, message = "A quantidade não pode ser menor que zero")
    private int estoque;

    private String descricao;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
