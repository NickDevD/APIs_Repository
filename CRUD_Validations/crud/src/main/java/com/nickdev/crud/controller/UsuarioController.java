package com.nickdev.crud.controller;

import com.nickdev.crud.dto.UsuarioRequestDTO;
import com.nickdev.crud.dto.UsuarioResponseDTO;
import com.nickdev.crud.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuariosService user;


    public UsuarioController(UsuariosService user) {
        this.user = user;
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioRequestDTO dados){
        UsuarioResponseDTO response = user.criar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
