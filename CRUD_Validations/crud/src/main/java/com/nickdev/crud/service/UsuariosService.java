package com.nickdev.crud.service;

import com.nickdev.crud.dto.UsuarioRequestDTO;
import com.nickdev.crud.dto.UsuarioResponseDTO;
import com.nickdev.crud.model.Usuarios;
import com.nickdev.crud.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    private final UsuariosRepository repository;

    public UsuariosService(UsuariosRepository repository){
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dados){
        Usuarios usuario = new Usuarios();
        usuario.setName(dados.name());

        Usuarios usuarioSalvo = repository.save(usuario);

        return  new UsuarioResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getName(),
                usuarioSalvo.getDataHoraRegistro()
        );

    }

}
