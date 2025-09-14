package com.api.itau.model;

import java.time.OffsetDateTime;

public class Transaction {
    private Double valor;
    private OffsetDateTime dataHora;
    private String descricaoInterna;

    public Transaction(){

    }

    public Transaction(Double valor, OffsetDateTime dataHora, String descricaoInterna) {
        this.valor = valor;
        this.dataHora = dataHora;
        this.descricaoInterna = descricaoInterna;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricaoInterna() {
        return descricaoInterna;
    }
}
