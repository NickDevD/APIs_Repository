package desafio.itau.springteste.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransactionRequest {
    @NotNull // Não serão aceitos valores nulos
    @Min(0) // Valores 0 não serão aceitos
    private Double valor;

    @NotNull
    private OffsetDateTime datahora;

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDatahora() {
        return datahora;
    }
}
