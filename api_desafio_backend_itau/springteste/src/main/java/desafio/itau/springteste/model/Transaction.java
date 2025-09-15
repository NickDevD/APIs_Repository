package desafio.itau.springteste.model;

import java.time.OffsetDateTime;

public class Transaction {
    private Double valor;
    private OffsetDateTime datahora;

    public Transaction(final Double valor, final OffsetDateTime datahora) {
        this.valor = valor;
        this.datahora = datahora;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDatahora() {
        return datahora;
    }
}
