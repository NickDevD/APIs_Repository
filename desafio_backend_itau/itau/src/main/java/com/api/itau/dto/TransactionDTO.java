package com.api.itau.dto;


import java.time.OffsetDateTime;

public record TransactionDTO(Double valor, OffsetDateTime dataHora) {
}
