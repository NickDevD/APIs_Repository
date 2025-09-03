package com.api.teste.model;

import java.time.LocalDate;
import java.util.Date;

public class Comida {
    String nome;
    LocalDate dataExpiracao;

    public Comida(String nome, LocalDate dataExpiracao) {
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
}
