package com.nickdev.crud.repository;

import com.nickdev.crud.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {
}
