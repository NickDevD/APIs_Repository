package com.nickdev.crud.dto;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
        java.util.UUID id, String name,
        LocalDateTime dataHoraRegistro
) {}
