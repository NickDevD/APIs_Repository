package com.api.teste.model;

import java.time.LocalDate;

public class Comida {
    Long id;
    String nome;
    LocalDate dataExpiracao;

    public Comida(String nome, LocalDate dataExpiracao, Long id) {
        this.id = id;
        this.nome = nome;
        this.dataExpiracao = dataExpiracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
